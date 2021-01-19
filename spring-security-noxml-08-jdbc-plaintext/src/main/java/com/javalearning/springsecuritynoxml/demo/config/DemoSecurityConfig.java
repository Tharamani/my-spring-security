/**
 * 
 */
package com.javalearning.springsecuritynoxml.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/**
 * @author Thara Created date and time : 18 Dec 2020 2:18:46 am
 */
@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	//add a reference to our security datasource
	@Autowired(required=true)
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// add our users for in memory authentication

		/*
		 * UserBuilder users = User.withDefaultPasswordEncoder();
		 * auth.inMemoryAuthentication().withUser(users.username("john").password(
		 * "test123").roles("EMPLOYEE"))
		 * .withUser(users.username("mary").password("test123").roles("EMPLOYEE",
		 * "MANAGER"))
		 * .withUser(users.username("susan").password("test123").roles("EMPLOYEE",
		 * "ADMIN"));
		 */
		
		//use jdbc authentication...no more hardcoding users
		auth.jdbcAuthentication().dataSource(securityDataSource);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				// .anyRequest().authenticated() //allow access to everyone
				// ("/") -> rootpath
				// ("/leaders/**") -> leaders followed by sub-directory followed by manager
				.antMatchers("/").hasRole("EMPLOYEE")
				.antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN")
				.and()
				.formLogin()
					.loginPage("/showMyLoginPage")
					.loginProcessingUrl("/authenticatedUser")
					.permitAll()
				.and()
				.logout()
				.permitAll()
				.and()
				.exceptionHandling()
					.accessDeniedPage("/access-denied");
	}

}
