<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="../webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>Movie uploader ajax</h1>

		<form enctype="multipart/form-data" id="fileUploadForm">
			<input type="file" name="file" /><br />
			<br /> <input type="submit" value="Submit" id="btnSubmit"
				class="btn btn-primary" />
		</form>

		<h1>Ajax Post Result</h1>
		<pre>
    <span id="result"></span>
</pre>
	</div>

	<script type="text/javascript"
		src="../webjars/jquery/2.2.4/jquery.min.js"></script>

	<script type="text/javascript" src="../js/Web/Index.js"></script>

</body>
</html>
