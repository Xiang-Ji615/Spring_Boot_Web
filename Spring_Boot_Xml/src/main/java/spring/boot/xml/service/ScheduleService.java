package main.java.spring.boot.xml.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.core.annotation.AliasFor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class ScheduleService {

	@Scheduled(cron="*/5 * * * * ?")
	public void demoServiceMethod()
	{
		System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());
	}
	
	@PostConstruct
	public void postConstruct(){
		System.out.println("Scheduled services initialized");
	}
	

}
