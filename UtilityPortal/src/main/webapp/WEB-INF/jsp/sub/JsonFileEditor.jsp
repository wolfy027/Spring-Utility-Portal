<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<!-- Scripts -->
<script src="/css/assets/js/jquery.min.js"></script>
<script src="/css/assets/js/jquery.poptrox.min.js"></script>
<script src="/css/assets/js/skel.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Editor</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="/css/main.css" />
<link rel="icon" href="/images/icons/gear1.ico">
<script type="text/javascript">
	function disableF5(e) {
		if ((e.which || e.keyCode) == 116)
			e.preventDefault();
	};
	// To disable f5
	/* jQuery < 1.7 */
	$(document).bind("keydown", disableF5);
	/* OR jQuery >= 1.7 */
	$(document).on("keydown", disableF5);

	// To re-enable f5
	/* jQuery < 1.7 */
	$(document).unbind("keydown", disableF5);
	/* OR jQuery >= 1.7 */
	$(document).off("keydown", disableF5);
</script>
<style>
body {
	overflow: hidden;
}

textarea {
	resize: none;
	border: solid 1px orange;
	overflow-y: scroll;
	overflow-x: scroll;
	background-color: white;
	color: black;
	font-size: 12px;
	font-family: Arial;
}

td {
	text-align: center;
	width: 700px;
}

input[type=submit] {
	width: 20em;
	height: 2.5em;
}

input[type=button] {
	width: 20em;
	height: 2.5em;
}
</style>
</head>
<body bgcolor="#E6E6FA">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script>
		function uploadFile() {
			$.ajax({
				type : "POST",
				url : "Upload",
				data : ({
					textAreaContent : $('#txtArea').val()
				}),
				success : function() {
					showAlert('Saved.')
				}
			});
		}

		function refreshPage() {
			window.location.reload();
		}

		function showAlert(message) {
			window.alert(message);
		}
	</script>
	<%
		String requestEditorFilePath = request.getParameter("editorFilePath");
		if (requestEditorFilePath != null)
			session.setAttribute("editorFilePath", requestEditorFilePath);
		String sessionEditorFilePath = session.getAttribute("editorFilePath").toString();

		String path = sessionEditorFilePath;
		BufferedReader reader = new BufferedReader(new FileReader(request.getServletContext().getRealPath(path)));
		StringBuilder sb = new StringBuilder();
		String line, data = "";

		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		data = sb.toString();
		String referrer = request.getHeader("referer");
		if (referrer != null)
			if (referrer.contains("FilePathBuilder")) {
				data = request.getParameter("First");
			}
	%>
	<textarea id="txtArea" name="First" rows="28" cols="190" wrap="off"><%=data%></textarea>
	<table>

		<tr>
			<td><input type="button" onclick="uploadFile();" value="SAVE"></input></td>
			<td><a href="/AutomationUtilityPortal/">Home</a></td>
			<td><input type="button" onclick="refreshPage()" value="REFRESH"></input></td>
		</tr>
	</table>
	<input type="hidden" id="thisField" name="inputName" value="path">
</body>
</html>
<script src="/css/assets/js/main.js"></script>