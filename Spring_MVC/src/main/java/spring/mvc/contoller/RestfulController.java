package main.java.spring.mvc.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Rest")
public class RestfulController {

	@RequestMapping(value="Test", method=RequestMethod.GET)
	public Object test() {
		return "Test";
	}
}
