<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>

<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>
<!DOCTYPE html>
<html>
<head>
<%if(session.getAttribute("user")==null){
	response.sendRedirect("/login.htm");
	}%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Details</title>

	<script src="jsfile/ui/jquery-1.9.1.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet">
     <script src="js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="jsfile/datepick/jquery.datepick.css"> 
	<script type="text/javascript" src="jsfile/datepick/jquery.datepick.js"></script>
	<script type="text/javascript" src="jsfile/userdetail.js"></script>
</head>
</head>
<body>

<body >
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container" >
	<div class="center-block"><h1>User Details</h1></div>
	<form name="register" id="reg" action="" method="POST" class="form" role="form">
		<div class=row>
			<div class="form-group">
     		<div class="col-xs-4">
				<label for="image">Upload Image :</label>			
				<input type="file" name="image" id="image">
				<button type="button" id="upload" class="btn btn-default">Upload</button>
				<br>
				<div class="progress progress-striped active" id=progress-div>
			  		<div id="progress" class="progress-bar"  role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" >
			    		<span class="sr-only" id=progress-span></span>
			  		</div>
				</div>
			</div>
		</div>
		</div>
		<div class=row>
		<div class="form-group">
			<div class="col-sm-4">
				<label for=name>Name<span style="color: red;">*</span>:</label>
				<input type="text" class="form-control"placeholder="Your Full Name" name="name" required="required" value= '${user}' id="name">
			</div>
		</div>
		</div>
		<div class=row>
		<div class="form-group">
			<div class="col-sm-4">
				<label  for=email>Email-Address<span style="color: red;">*</span>:</label>			
				<input type="email" class="form-control" name="email" placeholder="Valid Email Address" required="required" id="email" value= '${email}'>
			</div>
		</div>
		</div>
		<div class=row>
		<div class="form-group">
			<div class="col-sm-4">
				<label for=pass>Password<span style="color: red;">*</span>:</label>
				<input type="password" class="form-control" name="password" placeholder="Password" required="required" id="pass" value='${pass}' >
			</div>
		</div>
		</div>
		<div class=row>
		<div class="form-group">
			<div class="col-sm-4">
				<label for=dob>Date Of Birth<span style="color: red;">*</span>:</label>
				<input type="text" id="dob" class="form-control" name="dob" required="required" placeholder="MM/DD/YYYY" value='${dob}' >
			</div>
		</div>
		</div>
		<div class=row>
		<div class="form-group">
			<div class="col-sm-4">
				<label for=contact>Contact NO.<span style="color: red;">*</span>:</label>			
				<input type="text"  class="form-control" name="contact" placeholder="Contact Number" value= '${cont}' id="contact" required="required">
			</div>
		</div>
		</div>
		<div class=row>
		<div class="form-group">
			<div class="col-sm-4">
				<label for=city>Current Location<span style="color: red;">*</span>:</label>
				<input type="text" id="city" class="form-control" name="city" required="required" placeholder="City Name" value= '${city}'>
			</div>
		</div>
		</div>
	<br>
		<div class="form-group">
		
			<button type="button" class="btn btn-primary " id="edit">Edit</button>
		
			<button type="button" class="btn btn-success " id="save">Save</button>
	
		</div>
	
	</form>
	
	<div class="col-xs-4">
		<p id=#result></p>
	</div>
	</div>
	
	
	
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>