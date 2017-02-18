package main.java.spring.hikari.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:Spring.xml")
public class App implements CommandLineRunner {

	@Autowired
	DataSource dataSource;
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(App.class);
//		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Cool");
		System.out.println("Database : " +dataSource);
	}
}
