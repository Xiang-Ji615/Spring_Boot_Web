package main.java.spring.boot.controllers;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.java.spring.boot.daos.IPersonDao;
import main.java.spring.boot.models.Person;

@RestController
@RequestMapping("Rest")
public class RestfulContoller {
	
	
	@Autowired
	@Resource(name="PersonDao${develop.env}")
	private IPersonDao personDao;

	public void setPersonDao(IPersonDao personDao) {
		this.personDao = personDao;
	}

	@RequestMapping(value="Test", method=RequestMethod.GET)
	public Object test() {
		return "Test";
	}
	
	@RequestMapping(value="getPerson", method=RequestMethod.GET)
	public Object findPersonById(@Valid Person person, Errors errors) {
		if(errors.hasErrors()){
			FieldError error = (FieldError)errors.getAllErrors().get(0);
			String errorMsg = error.getField() + " : " + error.getDefaultMessage();
			return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMsg);
		}
		return personDao.getPerson(person.getId());
	}

}
