
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
<%if(session.getAttribute("user")!=null){
		response.sendRedirect("/login.htm");
	}%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register</title>


	<script src="jsfile/ui/jquery-1.9.1.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet">
     <script src="js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="jsfile/datepick/jquery.datepick.css"> 
	<script type="text/javascript" src="jsfile/datepick/jquery.datepick.js"></script>

	<script type="text/javascript" src="jsfile/register.js"></script>

</head>
<body >
	
<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container" >
	
	
	<div class="center-block"><h1>Register YourSelf</h1></div>
	<form action="<%= blobstoreService.createUploadUrl("/image") %>" method="post" id="imgeupload" class="form-horizontal" role="form">
     	<div class="form-group">
			<label class="col-sm-2 control-label">Upload Image :</label>
			<div class="col-xs-4">
				<input type="file" name="image" id="image">
				<button type="submit" id="upload" class="btn btn-default">Upload</button>
			</div>
		</div>
	</form>
	
	<form name="register" id="reg" action="" method="POST" class="form-horizontal" role="form">
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Name<span style="color: red;">*</span>:</label>
			<div class="col-xs-4">
				<input type="text" placeholder="Your Full Name" class="form-control" name="name" required="required"  id="name">
				<span id="namespan" class="help-block"></span>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Email-Address<span style="color: red;">*</span>:</label>
			<div class="col-xs-4">
				<input type="email" class="form-control" name="email" placeholder="Valid Email Address" required="required" id="email" >
				<span id="emailspan" class="help-block"></span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Password<span style="color: red;">*</span>:</label>
			<div class="col-xs-4">
				<input type="password" class="form-control" name="password" placeholder="Password" required="required" id="pass">
				<span id="passwordspan" class="help-block"></span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Date Of Birth<span style="color: red;">*</span>:</label>
			<div class="col-xs-4">
				<input type="text" id="dob" class="form-control" name="dob" required="required" placeholder="MM/DD/YYYY" >
				<span id="dobspan" class="help-block"></span>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">Contact NO.<span style="color: red;">*</span>:</label>
			<div class="col-xs-4">
				<input type="text"  class="form-control" name="contact" placeholder="Contact Number"  id="contact" required="required">
				<span id="contactspan" class="help-block"></span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Current Location<span style="color: red;">*</span>:</label>
			<div class="col-xs-4">
				<input type="text" id="city" class="form-control" name="city" required="required" placeholder="City Name" >
				<span id="locationspan" class="help-block"></span>
			</div>
		</div>
		<div class="col-sm-2">
			<button type="submit" id=submit class="btn btn-primary pull-right">Register</button>
		</div>
			<button class="btn btn-default" type="reset" >Reset</button>
	</form>
	</div>
	<div id="regsuccess" ><h2>Congrats!!!! You have been registerd success fully. </h2><br/>
		<p>Click Here for <a href="/login.htm" >Login</a></p>	
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>