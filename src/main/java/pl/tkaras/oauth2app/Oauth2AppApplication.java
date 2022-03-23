package pl.tkaras.oauth2app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import pl.tkaras.oauth2app.security.JwtFilter;

import java.util.Collections;

@SpringBootApplication
public class Oauth2AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2AppApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.setUrlPatterns(Collections.singleton("/api/hello/*"));
		return filterRegistrationBean;
	}
}
