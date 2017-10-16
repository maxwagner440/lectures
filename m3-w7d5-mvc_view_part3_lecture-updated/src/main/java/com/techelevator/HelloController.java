package com.techelevator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class HelloController {

	@RequestMapping("/")
	public String displayGreeting() {
		
		return "index";
	}

	@RequestMapping("/aboutUs")
	public String showAboutUs() {
		return "aboutUs";
	}
	
	@RequestMapping("/link/favorites")
	public String showLinks() {
		return "link/favoriteLinks";
		
	}
}
