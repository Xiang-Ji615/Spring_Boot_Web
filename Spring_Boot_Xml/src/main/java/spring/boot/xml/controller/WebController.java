package main.java.spring.boot.xml.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.spring.boot.xml.model.User;

@Controller
@RequestMapping(value="Web")
public class WebController {
	
	@RequestMapping(value="Index", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String Index(ModelMap map, @ModelAttribute User user){
		return "Web/Index";
	}

	@ModelAttribute("Attr1")
	public String getAttr1(){
		System.out.println("Model Attribue Triggered");
		return "JJ Attr1";
	}
	
	@ModelAttribute("Attr2")
	public String getAttr2(ModelMap model,String user){
		System.out.println(user);
		System.out.println("Model Attribue222222 Triggered");
		return "JJ Attr2";
	}
	
}
