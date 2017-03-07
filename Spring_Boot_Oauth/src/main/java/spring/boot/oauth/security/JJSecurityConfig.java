package main.java.spring.boot.oauth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JJSecurityConfig {
	
	@Autowired
    private OAuth2SecurityConfiguration securityConfig;
}
