<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="subTitle" value="Mortgage Calculator" />
<%@ include file="common/header.jspf" %>	

<h2>Your Calculated Mortgage Payment</h2>

<table id="loanPaymentCalculationResults">
	<tr>
		<th>Loan Amount:</th>
		<td>$<c:out value="${param.loanAmount}" /></td>
	</tr>
	<tr>
		<th>Loan Term:</th>
		<td><c:out value="${param.loanTerm}" /> years</td>
	</tr>
	<tr>
		<th>Interest Rate:</th>
		<td><c:out value="${param.interestRate}" />%</td>
	</tr>
	<tr>
		<th>Monthly Payment:</th>
		<td><c:out value="${estimate.monthlyPayment}" /></td>
	</tr>
</table>

<%@ include file="common/footer.jspf" %>	