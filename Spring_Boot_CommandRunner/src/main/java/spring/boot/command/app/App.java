package main.java.spring.boot.command.app;

import javax.swing.JOptionPane;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

	public static void main(String[] args) throws Exception {

		// disabled banner, don't want to see the spring logo
		SpringApplication app = new SpringApplication(App.class);
		app.setHeadless(false);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);

	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Spring boot command runner is started!");
		JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");
	}

}
