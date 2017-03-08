package main.java.spring.boot.security.oauth.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import main.java.spring.boot.security.oauth.viewmodels.ViewModelIndex;

@Controller
@RequestMapping(value = "Web")
public class WebController {

	@RequestMapping(path = "Login", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
	public String login(ModelMap model, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "msg", required = false) String msg) {
		if (error != null) {
			model.addAttribute("Error", "Invalid uername or password");
		}
		if (msg != null) {
			model.addAttribute("Msg", "Log out successfully");
		}
		return "auth/login";
	}

	@RequestMapping(value = "Index", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
	public String index(ModelMap model) {
		ViewModelIndex viewModelIndex = new ViewModelIndex();
		viewModelIndex.setTitle("JJ Title");
		if(isRememberMeAuthenticated()){
			viewModelIndex.setTitle("JJ Title Remeber me");
		}
		model.addAttribute("ViewModel", viewModelIndex);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUser = auth.getName();
		loggedUser = loggedUser.equals("anonymousUser")?"": auth.getName();
		model.addAttribute("loggedUser", loggedUser);
		return "index";
	}
	
	/**
	 * Check if user is login by remember me cookie, refer
	 * org.springframework.security.authentication.AuthenticationTrustResolverImpl
	 */
	private boolean isRememberMeAuthenticated() {

		Authentication authentication =
                    SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return false;
		}

		return RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass());
	}

	/**
	 * save targetURL in session
	 */
	private void setRememberMeTargetUrlToSession(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session!=null){
			session.setAttribute("targetUrl", "/admin/update");
		}
	}

	/**
	 * get targetURL from session
	 */
	private String getRememberMeTargetUrlFromSession(HttpServletRequest request){
		String targetUrl = "";
		HttpSession session = request.getSession(false);
		if(session!=null){
			targetUrl = session.getAttribute("targetUrl")==null?""
                             :session.getAttribute("targetUrl").toString();
		}
		return targetUrl;
	}
	
	@RequestMapping(value="GetPDF", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public Object downloadPDF(){
		return new ModelAndView("pdfView");
	}

}
