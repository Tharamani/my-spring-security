package com.javalearning.springsecuritynoxml.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * configure componentscanning,annotation driven,viewresolver
 *@author Thara
 *Created date and time : 18 Dec 2020 2:10:29 am
 */
@Configuration
@EnableWebMvc // replacement for spring.xml file -> enable annotation driven
@ComponentScan(basePackages = "com.javalearning.springsecuritynoxml.demo")
public class DemoAppConfig {

	// define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
