package main.java.spring.web.socket.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="Rest")
public class RestfulController {

	@RequestMapping(value="Test", method=RequestMethod.GET)
	public Object Test(){
		return "JJ Test";
	}
}
