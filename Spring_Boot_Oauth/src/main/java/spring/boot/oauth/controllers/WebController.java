package main.java.spring.boot.oauth.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="Web")
public class WebController {

	@RequestMapping(value="Page1", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String page1(ModelMap model){
		return "page1";
	}
	
	@RequestMapping(value="Page2", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public String page2(ModelMap model){
		return "page2";
	}
}
