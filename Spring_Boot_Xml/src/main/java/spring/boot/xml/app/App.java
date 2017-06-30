package main.java.spring.boot.xml.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import main.java.spring.boot.xml.config.AppConfig;

@SpringBootApplication
public class App extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}

	public static void main(String[] args) throws Exception {
		Object[] objects = new Object[2];
		objects[0] = App.class;
		objects[1] = AppConfig.class;
		SpringApplication.run(objects, args);
	}
}
	