package main.java.spring.boot.xml.controller;


import java.util.Arrays;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.java.spring.boot.xml.model.User;

@RestController
@RequestMapping(value="Rest")
public class RestfulController {

	@RequestMapping(value="Test", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public ResponseEntity<?> test(){
		return ResponseEntity.ok("Hello world by JJ");
	}
	
	@RequestMapping(value="User", method=RequestMethod.POST, produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<?>  userTest(){
		System.out.println("User api works");
		return ResponseEntity.ok(new User(1, "JJ", "P@ssw0rd"));
	}
}
