/**
 * 
 */
package com.javalearning.springsecuritynoxml.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Thara
 *Created date and time : 18 Dec 2020 1:14:06 am
 */
@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
}
