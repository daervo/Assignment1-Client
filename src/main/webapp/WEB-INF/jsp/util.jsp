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
	<c:out value="${summariseMarketData_error}"></c:out>
	<c:out value="${summariseMarketData_eventSetID}"></c:out>
	<c:out value="${summariseMarketData_sec}"></c:out>
	<c:out value="${summariseMarketData_startDate}"></c:out>
	<c:out value="${summariseMarketData_endDate}"></c:out>
	<c:out value="${summariseMarketData_currencyCode}"></c:out>
	<c:out value="${summariseMarketData_fileSize}"></c:out>
	<form method=GET action="index">
		<input type="submit" value="Go Back" /><br />
	</form>
</body>
</html>
