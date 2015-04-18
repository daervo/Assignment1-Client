<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TopDownSimpleService Client Application</title>
</head>
<body>
	<h1>Welcome to TopDownSimpleService Client Application</h1>
	<br />
	<h2>Current EventSetIds:</h2>
	<c:out value="${eventSetIDs}"></c:out>
	<!-- The return value from the service is: <b><c:out value="${returnData}"></c:out></b>-->
	<form method=POST action="summariseMarketData">
		<h2>Summarise Market Data</h2>
		EventSetID:<input type="text" name="eventSetID" /> <input
			type="submit" value="Submit" /><br />
	</form>
	<c:out value="${summariseMarketData_error}"></c:out><br />
	<c:out value="${summariseMarketData_eventSetID}"></c:out><br />
	<c:out value="${summariseMarketData_sec}"></c:out><br />
	<c:out value="${summariseMarketData_startDate}"></c:out><br />
	<c:out value="${summariseMarketData_endDate}"></c:out><br />
	<c:out value="${summariseMarketData_currencyCode}"></c:out><br />
	<c:out value="${summariseMarketData_fileSize}"></c:out><br />
	<form method="POST" action="currencyConvert">
		<h2>Currency Convert</h2>
		<table>
			<tr>
				<td>EventSetID:</td>
				<td><input type="text" name="eventSetID" /></td>
			</tr>
			<tr>
				<td>Target Currency (eg. USD, EUR):</td>
				<td><input type="text" name="targetCurrency" /></td>
			</tr>
			<tr>
				<td>Target Date (eg. YYYY-MM-DD):</td>
				<td><input type="text" name="targetDate" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	<c:out value="${currencyConvert_output}"></c:out><br />
	</form>
	<form method=POST action="visualiseMarketData">
		<h2>Visualise Market Data</h2>
		EventSetID:<input type="text" name="eventSetID" /> <input
			type="submit" value="Submit" /><br />
	<c:out value="${visualiseMarketData_output}"></c:out><br />
	<c:out value="${visualiseMarketData_error}"></c:out><br />
	</form>
	<form method=GET action="index">
		<input type="submit" value="Go Back" /><br />
	</form>
</body>
</html>
