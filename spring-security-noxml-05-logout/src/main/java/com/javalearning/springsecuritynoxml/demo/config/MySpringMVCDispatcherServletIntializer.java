/**
 * 
 */
package com.javalearning.springsecuritynoxml.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * servlet (web.xml) initializer
 *@author Thara
 *Created date and time : 18 Dec 2020 1:04:03 am
 */
public class MySpringMVCDispatcherServletIntializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		//servlet definition for dispatcher servlet
		return new Class[] {DemoAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		//servlet url mapping 
		return new String[] {"/"};
	}

}
