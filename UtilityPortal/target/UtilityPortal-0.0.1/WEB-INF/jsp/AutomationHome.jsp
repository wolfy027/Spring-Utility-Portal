<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> --%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>

<html>
<head>
<title>Automation Utilities Home</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link href="/css/main.css" rel="stylesheet" />
<link rel="icon" href="/images/icons/gear1.ico">
<style>
.thumbnails  div a {
	height: 200px;
	width: 150px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script>
	function futureTasks() {
		$
				.ajax({
					type : "GET",
					url : "JsonFileEditor",
					data : ({
						editorFilePath : '/files/fileServerPersistanceDirectory/FutureTasks.txt'
					}),
					success : function() {
						window.location.href = 'JsonFileEditor';
					}
				});
	}
</script>
</head>

<body>
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header">
			<span class="avatar"><img src="/images/automation2.gif" alt="" /></span>
			<h1>
				This is <strong>Hubworks Automation Team Portal</strong>, a Site
				having utilities for Automation Testers.
			</h1>
		</header>

		<!-- Main -->
		<section id="main">
			<!-- Thumbnails -->
			<section class="thumbnails">
				<div>
					<a href="fileChooser"> <img src="/images/thumbs/fileServer.png"
						alt="" />
						<h3>File Server</h3>
					</a>
				</div>
				<div>
					<a href="javascript:{}" onclick="futureTasks();"> <img
						src="/images/thumbs/futureTasks.png" alt="" />
						<h3>Upcoming Tasks</h3>
					</a>
				</div>
			</section>

		</section>

		<!-- Footer -->
		<footer id="footer">
			<a href="/AutomationUtilityPortal/"><p>Altametrics © 2016 All
					Right Reserved.</p></a>
		</footer>

	</div>

	<!-- Scripts -->
	<script src="/js/jquery.min.js"></script>
	<script src="/js/jquery.poptrox.min.js"></script>
	<script src="/js/skel.min.js"></script>
	<script src="/js/main.js"></script>

</body>
</html>