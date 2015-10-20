<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h4>
			<label>HTML ERROR CODE: </label><%=response.getStatus()%></h4>
	</div>
	<div>
		<p>
			<label>description:</label>
			<%=response.getHeader("description") %>
		</p>
	</div>
	<div>
		<p>
			<label>details:</label><br />
			<%=response.getHeader("stacktrace") %>
		</p>
	</div>
</body>
</html>