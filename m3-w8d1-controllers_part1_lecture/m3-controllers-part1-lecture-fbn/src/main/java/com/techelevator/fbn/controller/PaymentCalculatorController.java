package com.techelevator.fbn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.techelevator.fbn.model.MortgageLoanEstimate;
import java.math.BigDecimal;

@Controller
public class PaymentCalculatorController {

	@RequestMapping("/mortgageCalculatorInput")
	public String showMortgagePaymentCalculatorInputPage() {
		return "mortgageCalculatorInput";
	}
	
	@RequestMapping("/mortgageCalculatorResult")
	public String showMortgagePaymentCalculatorResults(
			@RequestParam int loanAmount,
			@RequestParam int loanTerm,
			@RequestParam BigDecimal interestRate,
			ModelMap modelHolder) {
		
		MortgageLoanEstimate estimate = new MortgageLoanEstimate(loanAmount, loanTerm, interestRate);
		modelHolder.put("estimate", estimate);
		
		return "mortgageCalculatorResult";
	}
}
