package jj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.util.UrlPathHelper;

import jj.aspect.JJAspect;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
		System.out.println("Matix variable works");
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }
	
	@Bean
	public JJAspect jjAspect() {
		return new JJAspect();
	}
}
