package main.java.spring.boot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Rest")
public class RestfulContoller {
	
	

	@RequestMapping(value="Test", method=RequestMethod.GET)
	public Object test() {
		return "Test";
	}
	

}
