package com.javalearning.springsecuritynoxml.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * configure componentscanning,annotation driven,viewresolver
 * 
 * @author Thara Created date and time : 18 Dec 2020 2:10:29 am
 */
@Configuration
@EnableWebMvc // replacement for spring.xml file -> enable annotation driven
@ComponentScan(basePackages = "com.javalearning.springsecuritynoxml.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	// set up a logger for diagnostics
	private Logger logger = Logger.getLogger(getClass().getName());

	// set up variable to hold the properties
	/**
	 * will hold data read from properties files
	 */
	@Autowired
	private Environment environment;

	// define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	// define a bean for our security datasource
	@Bean
	public DataSource securityDataSource() {

		// create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

		// set the jdbc driver class
		try {
			securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}

		// log the connection props
		logger.info("==========>jdbc url= " + environment.getProperty("jdbc.url"));
		logger.info("==========>jdbc user= " + environment.getProperty("jdbc.user"));

		// set database connection props
		securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		securityDataSource.setUser(environment.getProperty("jdbc.user"));
		securityDataSource.setPassword(environment.getProperty("jdbc.password"));

		// set connection pool props
		securityDataSource.setInitialPoolSize(getIntPropery("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntPropery("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntPropery("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntPropery("connection.pool.maxIdleTime"));

		return securityDataSource;
	}

	// need a helper method
	// read environment property and convert to int

	public int getIntPropery(String propName) {

		int i =0;
		
		String propVal = environment.getProperty(propName);

		// now convert to int
		int propIntVal = Integer.parseInt(propVal);
		System.out.println("====> propIntVal i : "+ i + propIntVal);
		return propIntVal;
	}
}
