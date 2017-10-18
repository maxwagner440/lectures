<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="subTitle">New Checking Account Application</c:param>
</c:import>

<h2>New Checking Account Application</h2>
<h3>Summary</h3>

<table>
	<tr>
		<th>First Name:</th>
		<td><c:out value="${application.firstName}" /></td>
	</tr>
	<tr>
		<th>Last Name:</th>
		<td><c:out value="${application.lastName}" /></td>
	</tr>
	<tr>
		<th>Date of Birth:</th>
		<td><c:out value="${application.dateOfBirth}" /></td>
	</tr>
	<tr>
		<th>State of Birth:</th>
		<td><c:out value="${application.stateOfBirth}" /></td>
	</tr>
	<tr>
		<th>Email Address:</th>
		<td><c:out value="${application.emailAddress}" /></td>
	</tr>
	<tr>
		<th>Phone Number:</th>
		<td><c:out value="${application.phoneNumber}" /></td>
	</tr>
	<tr>
		<th>Street Address:</th>
		<td><c:out value="${application.addressStreet}" /></td>
	</tr>
	<tr>
		<th>Apartment:</th>
		<td><c:out value="${application.addressApartment}" /></td>
	</tr>
	<tr>
		<th>City:</th>
		<td><c:out value="${application.addressCity}" /></td>
	</tr>
	<tr>
		<th>State:</th>
		<td><c:out value="${application.addressState}" /></td>
	</tr>
	<tr>
		<th>ZIP:</th>
		<td><c:out value="${application.addressZip}" /></td>
	</tr>
</table>
<c:url var="completeApplicationUrl" value="/checkingApplication/completeApplication"/>
<form method="POST" action="${completeApplicationUrl}">
	<input type="submit" value="Submit Application" />
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />