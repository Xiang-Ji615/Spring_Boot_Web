package main.java.spring.boot.xml.event.handler;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import main.java.spring.boot.xml.event.JJEvent;

@Component
public class JJEventHandlerAnnotation {

	@EventListener(classes={JJEvent.class})
	public void consumeJJEvent(JJEvent event){
		System.out.println("Name is " + event.getName()+", Age is "+event.getAge());
	}
}
