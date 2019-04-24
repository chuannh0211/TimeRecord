<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Files</title>
</head>
<body>
	<div align="center">
		<h1>Upload file</h1>
		<hr>
		<form action="upload-file" enctype='multipart/form-data' method="get">
			<table border="1">
				<tr>
					<th>Choose File</th>
					<th>Action</th>
				</tr>
				<tr>
					<td><input type="file" name="path"></td>
					<td><button>Submit</button> ${msg }</td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>