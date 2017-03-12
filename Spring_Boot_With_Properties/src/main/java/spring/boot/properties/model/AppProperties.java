package main.java.spring.boot.properties.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value="server")
public class AppProperties {
	String username;
	String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AppProperties(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public AppProperties() {
		super();
	}

	@Override
	public String toString() {
		return "AppProperties [username=" + username + ", password=" + password + "]";
	}

}
