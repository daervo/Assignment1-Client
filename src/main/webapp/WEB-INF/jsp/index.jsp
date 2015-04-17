<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TopDownSimpleService Client Application</title>
</head>
<body>
<h1>Welcome to TopDownSimpleService Client Application</h1><br />
<h2>Current EventSetIds:</h2>

<form action="index" method="post" >
<h2>Import Market Data</h2>
Sec: <input type="text" name="sec"/><br />
Start Date (eg. 01-01-2010): <input type="text" name="startDate"/><br />
End Date (eg. 01-01-2010): <input type="text" name="endDate"/><br />
Source URL (http://au.finance.yahoo.com): <input type="text" name="dataSourceURL"/><br />
<input type="hidden" name="action" value="importMarket">
<input type="submit" value="Submit">
</form>
<form action="index" method="post">
<h2>Download File</h2>
Event Set ID (eg. abc-abc-123): <input type="text" name="eventSetID"/><br />
<input type="hidden" name="action" value="downloadFile">
<input type="submit" value="Submit">
</form>
<!-- The return value from the service is: <b><c:out value="${returnData}"></c:out></b>-->
</body>
</html>
