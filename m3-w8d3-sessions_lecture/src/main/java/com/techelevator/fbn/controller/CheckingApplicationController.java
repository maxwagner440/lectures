package com.techelevator.fbn.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.techelevator.fbn.model.CheckingAccountApplication;

@Controller
@RequestMapping("/checkingApplication")
public class CheckingApplicationController {

	@RequestMapping(path={"/","/personalInformationInput"}, method=RequestMethod.GET)
	public String displayPersonalInformationInput() {
		return "checkingApplication/personalInformationInput";
	}
	
	@RequestMapping(path="/personalInformationInput", method=RequestMethod.POST)
	public String processPersonalInformationInput(HttpSession session, @ModelAttribute CheckingAccountApplication application) {
		session.setAttribute("application", application);
		return "redirect:/checkingApplication/addressInput";
	}
	
	@RequestMapping(path="/addressInput", method=RequestMethod.GET)
	public String displayAddressInput() {
		return "checkingApplication/addressInput";
	}
	
	@RequestMapping(path="/addressInput", method=RequestMethod.POST)
	public String processAddressInput(@ModelAttribute("application") CheckingAccountApplication application) {
		
		return "redirect:/checkingApplication/summary";
	}
	
	@RequestMapping(path="/summary", method=RequestMethod.GET)
	public String displaySummary() {
		return "checkingApplication/summary";
	}
	
	@RequestMapping(path="/completeApplication", method=RequestMethod.POST)
	public String processApplication(HttpSession session) {
				
		/* This is where we would do something useful with the application, 
		 * such as save it to a database. */
		session.removeAttribute("application");
				
		return "redirect:/checkingApplication/thankYou";
	}
	
	@RequestMapping(path="/thankYou", method=RequestMethod.GET)
	public String displayThankYou() {
		return "checkingApplication/thankYou";
	}
}
