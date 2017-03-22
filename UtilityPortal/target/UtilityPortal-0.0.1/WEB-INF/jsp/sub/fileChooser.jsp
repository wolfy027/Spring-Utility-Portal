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
<script src="/js/jquery.min.js"></script>
<script src="/js/jquery.poptrox.min.js"></script>
<script src="/js/skel.min.js"></script>

<!DOCTYPE HTML>
<html>
<head>
<title>File Chooser</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="icon" href="/images/icons/gear1.ico">
<link rel="stylesheet" href="/css/main.css" />
</head>
<body>
	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Header -->
		<header id="header">
			<div id="fileTypeDiv">
				<table>
					<tbody>
						<tr>
							<td><strong>File Type :</strong></td>
							<td><select id='fileTypeDropdown'
								style="display: inline-block; width: 80%;">
									<option>Locators</option>
									<option>Messages</option>
									<option>Queries</option>
							</select></td>
						</tr>
					</tbody>
				</table>

			</div>
			<br>
			<form name="locatorsForm" method="post" action="FilePathBuilder">
				<div id="locatorsDiv">
					<table>
						<tbody>
							<tr>
								<td><strong>Module IID :</strong></td>
								<td><select id='locatorsModuleSelectorId'
									name="locatorsModuleSelectorName"
									style="display: inline-block; width: 80%;">

										<%
											for (String str : fileServerSetup.getModuleId()) {
										%>
										<option><%=str%></option>
										<%
											}
										%>

								</select></td>
							</tr>
							<tr>
								<td><strong>Browser Type :</strong></td>
								<td><select id='locatorsBrowserSelectorId'
									name='locatorsBrowserSelectorName'
									style="display: inline-block; width: 80%;">
										<%
											for (String str : fileServerSetup.getBrowserId()) {
										%>
										<option><%=str%></option>
										<%
											}
										%>
								</select></td>
							</tr>
						</tbody>
					</table>
					<input type="submit" value=":: Edit Locators ::" />
				</div>

			</form>
			<form name="messagesForm" method="post" action="FilePathBuilder">
				<div id="messagesDiv">
					<table>
						<tbody>
							<tr>
								<td><strong>Module IID :</strong></td>
								<td><select id='messagesModuleSelectorId'
									name='messagesModuleSelectorName'
									style="display: inline-block; width: 80%;">
										<%
											for (String str : fileServerSetup.getModuleId()) {
										%>
										<option><%=str%></option>
										<%
											}
										%>
								</select></td>
							</tr>
							<tr>
								<td><strong>Browser Type :</strong></td>
								<td><select id='messagesPlatformSelectorId'
									name='messagesPlatformSelectorName'
									style="display: inline-block; width: 80%;">
										<%
											for (String str : fileServerSetup.getDeviceTypeId()) {
										%>
										<option><%=str%></option>
										<%
											}
										%>
								</select></td>
							</tr>
							<tr>
								<td><strong>Message Type :</strong></td>
								<td><select id='messagesMessageTypeSelectorId'
									name='messagesMessageTypeSelectorName'
									style="display: inline-block; width: 80%;">
										<%
											for (String str : fileServerSetup.getMessageTypeId()) {
										%>
										<option><%=str%></option>
										<%
											}
										%>
								</select></td>
							</tr>
						</tbody>
					</table>
					<input type="submit" value=":: Edit Messages ::" />
				</div>
			</form>
			<form name="queriesForm" method="post" action="FilePathBuilder">
				<div id="queriesDiv">
					<input type="submit" value=":: Edit Queries ::" />
				</div>
			</form>


		</header>

		<!-- Main -->
		<section id="main"></section>


		<!-- Footer -->
		<!-- Footer -->
		<footer id="footer">
			<a href="/AutomationUtilityPortal/"><p>Altametrics © 2016 All
					Right Reserved.</p></a>
		</footer>

	</div>



</body>
</html>
<script src="/js/main.js"></script>