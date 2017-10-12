package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NameController {

	@RequestMapping("/names")
	public String showNames(ModelMap modelHolder) {
		
		List<String> names = new ArrayList<String>();
		names.add("Ann");
		names.add("Bob");
		names.add("Maximillion");
		names.add("Laurey");
		names.add("Sand");
		names.add("Ishaan");
		names.add("Kris");
		names.add("John");
		names.add("Richie");
		names.add("Tory");
		names.add("Aeron");
		names.add("Joan");
		names.add("Heath R.");
		names.add("Can");
		names.add("Jerry");
		names.add("Jiff");
		
		/* This line adds a model with the name "nameList" to the JSP
		 * that contains our list of student names. This will later be 
		 * used by the View (i.e. JSP) to display student names in HTML */
		modelHolder.put("nameList", names);
		
		/* This line forwards the request to the JSP */
		return "displayNames";
	}
}
