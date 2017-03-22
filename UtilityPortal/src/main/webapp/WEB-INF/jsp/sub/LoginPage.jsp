<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*,org.codehaus.jackson.JsonParseException,org.codehaus.jackson.map.*,JsonFile.FileServerSetup,java.io.*,java.net.*"%>
<%@ page errorPage="error.jsp"%>
<%
	ObjectMapper mapper = new ObjectMapper();
	String jsonFilePath = request.getServletContext().getRealPath("/setup/fileServerSetup.json");
	FileServerSetup fileServerSetup = mapper.readValue(new File(jsonFilePath), FileServerSetup.class);
%>
<!-- Scripts -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/jquery.poptrox.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/skel.min.js"></script>

<!DOCTYPE HTML>
<html>
<head>
<title>File Chooser</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="icon"
	href="${pageContext.request.contextPath}/images/icons/gear1.ico">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />
</head>
<body>
	<br><br><br><br><br><br>
	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Header -->
		<header id="header">
			<div id="fileTypeDiv">
				<form action="${pageContext.request.contextPath}/LoginValidation" method="POST">
					<table>
						<tr>
							<td>USERNAME</td>
							<td><input type="text" name="userName"></td>
						</tr>
						<tr>
							<td>PASSWORD</td>
							<td><input type="password" name="password"></td>
						</tr>
					</table>
					<input type="submit" value="SUBMIT" width="100" />
				</form>
			</div>
		</header>
	</div>
</body>
</html>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>