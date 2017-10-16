package com.techelevator.fbn.model;

import java.math.BigDecimal;
import java.math.MathContext;

public class MortgageLoanEstimate {

	private int loanAmount;
	private int loanTermInYears;
	private BigDecimal interestRate;

	public MortgageLoanEstimate(int loanAmount, int loanTermInYears, BigDecimal interestRate) {
		this.loanAmount = loanAmount;
		this.loanTermInYears = loanTermInYears;
		this.interestRate = interestRate;
	}
	
	public BigDecimal getMonthlyPayment() {
		int loanTermInMonths = loanTermInYears * 12;
		BigDecimal monthlyInterestRate = interestRate.setScale(10).divide(new BigDecimal("1200"), BigDecimal.ROUND_HALF_UP);

		BigDecimal rateForPayment = BigDecimal.ONE.subtract(monthlyInterestRate.add(BigDecimal.ONE).pow(- loanTermInMonths, MathContext.DECIMAL64));

		BigDecimal payment = new BigDecimal(loanAmount).multiply(monthlyInterestRate).divide(rateForPayment, BigDecimal.ROUND_HALF_UP);
		return payment.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
