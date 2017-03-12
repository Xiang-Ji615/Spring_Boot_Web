package main.java.spring.boot.properties.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import main.java.spring.boot.properties.model.AppProperties;

@SpringBootApplication
@ComponentScan(basePackages={"main.java"})
public class App implements CommandLineRunner {
	
	@Autowired
	AppProperties appProperties;

	public static void main(String[] args){
		  SpringApplication app = new SpringApplication(App.class);
	      app.run(args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(appProperties);
	}
}
