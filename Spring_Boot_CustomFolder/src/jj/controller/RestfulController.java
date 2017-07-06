package jj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="Rest")
public class RestfulController {

	@RequestMapping(value="HelloWorld", method=RequestMethod.GET)
	public Object helloWorld(){
		return "Hello world";
	}
}
