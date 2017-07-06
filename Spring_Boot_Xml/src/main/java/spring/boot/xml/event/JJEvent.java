package main.java.spring.boot.xml.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

public class JJEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String name;
	Integer age;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	
	public JJEvent(Object source, String name, Integer age) {
		super(source);
		this.name = name;
		this.age = age;
	}

}
