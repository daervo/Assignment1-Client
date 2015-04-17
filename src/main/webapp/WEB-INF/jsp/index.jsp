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
	<form:form method="POST" action="importMarket"
		modelAttribute="importMarketBean">
		<h2>Import Market Data</h2>
		<table>
			<tr>
				<td><form:label path="sec">Sec: </form:label></td>
				<td><form:input path="sec" /></td>
			</tr>
			<tr>
				<td><form:label path="startDate">Start Date (eg. 01-01-2010): </form:label></td>
				<td><form:input path="startDate" /></td>
			</tr>
			<tr>
				<td><form:label path="endDate">End Date (eg. 01-01-2010): </form:label></td>
				<td><form:input path="endDate" /></td>
			</tr>
			<tr>
				<td><form:label path="dataSourceURL">Source URL (http://au.finance.yahoo.com): </form:label></td>
				<td><form:input path="dataSourceURL" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	<form:form method="POST" action="downloadFile"
		modelAttribute="downloadFileBean">
		<h2>Download File</h2>
		<form:label path="eventSetID">EventSetID: </form:label>
		<form:input path="eventSetID" />
		<input type="submit" value="Submit" /><br/>
	</form:form>
	<c:out value="${downloadURL}"></c:out>
</body>
</html>
