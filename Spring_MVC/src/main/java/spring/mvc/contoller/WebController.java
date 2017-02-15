package main.java.spring.mvc.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping("/")
	public String index(Model model, String name){
		model.addAttribute("msg", "Hello "+name);
		return "index";
	}
}
