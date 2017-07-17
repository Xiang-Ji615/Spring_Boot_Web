package jj.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jj.model.User;

@RestController
@RequestMapping(value="Rest")
public class RestfulController {

	@RequestMapping(value="HelloWorld", method=RequestMethod.GET)
	public Object helloWorld(@RequestParam("dob") Date date){
		System.out.println(date);
		return "Hello world";
	}
	
	@RequestMapping(value="ModelAttr", method=RequestMethod.GET)
	public Object modelAttribute(@ModelAttribute User user, BindingResult bindingResult) {
		System.out.println(user.getDob());
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult.getErrorCount());
		}
		return user;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//		binder.addCustomFormatter(new DateFormatter("dd/MM/yyyy"));
//		System.out.println("Init Binder runs");
	}
}
