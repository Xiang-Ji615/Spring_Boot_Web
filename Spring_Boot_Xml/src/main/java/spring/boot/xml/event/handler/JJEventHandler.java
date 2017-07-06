package main.java.spring.boot.xml.event.handler;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import main.java.spring.boot.xml.event.JJEvent;

//@Component
public class JJEventHandler implements ApplicationListener<JJEvent> {

	@Override
	public void onApplicationEvent(JJEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Name is " + event.getName()+", Age is "+event.getAge());
	}

}
