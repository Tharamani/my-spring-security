/**
 * 
 */
package com.javalearning.springsecuritynoxml.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *@author Thara
 *Created date and time : 18 Dec 2020 8:10:59 am
 */
@Controller
public class LoginController {
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		return "fancy-login";
	}

}
