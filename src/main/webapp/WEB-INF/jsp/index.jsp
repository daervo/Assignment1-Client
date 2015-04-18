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
	<form method="POST" action="importMarket">
		<h2>Import Market Data</h2>
		<table>
			<tr>
				<td>Sec:</td>
				<td><input type="text" name="sec" /></td>
			</tr>
			<tr>
				<td>Start Date (eg. 01-01-2010):</td>
				<td><input type="text" name="startDate" /></td>
			</tr>
			<tr>
				<td>End Date (eg. 01-01-2010):</td>
				<td><input type="text" name="endDate" /></td>
			</tr>
			<tr>
				<td>Source URL (http://au.finance.yahoo.com):</td>
				<td><input type="text" name="dataSourceURL" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	<c:out value="${importMarketStatus}"></c:out>
	</form>
	<form method=POST action="downloadFile">
		<h2>Download File</h2>
		EventSetID:<input type="text" name="eventSetID" />
		<input type="submit" value="Submit" /><br/>
	</form>
	<c:out value="${downloadURL}"></c:out>
	<form method=GET action="utilPage">
		<h2>Market Data Utils</h2>
		<input type="submit" value="Go To Market Data Util Page" /><br/>
	</form>
</body>
</html>
