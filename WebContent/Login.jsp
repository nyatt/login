<%@page import="sun.util.logging.resources.logging"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<p>Welcome </p>
<form  action="Servlet" method="post" >
	<label for="txtLoging">login:</label>
	<input id="txtLoging" name="txtLoging" type="text" value="<%=session.getAttribute("login")%>"/><br/>
	<label for="txtPassword">Password:</label>
	<input name="txtPassword" type="text" value="<%=session.getAttribute("password")%>"/><br/>
	<br/>
	<input name="btnConnect" type="submit"/><br/>
</form>
</body>
</html>