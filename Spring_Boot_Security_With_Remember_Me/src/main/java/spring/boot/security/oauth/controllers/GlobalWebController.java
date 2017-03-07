package main.java.spring.boot.security.oauth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GlobalWebController {

	@RequestMapping(value="/")
	public Object redirectToLogin(){
		return "redirect:/Web/Index";
	}
}
