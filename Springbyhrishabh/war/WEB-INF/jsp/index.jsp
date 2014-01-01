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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Login</title>

	<!--- CSS --->
	<script src="jsfile/ui/jquery-1.9.1.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet">
     <script src="js/bootstrap.min.js"></script>
     <link rel="stylesheet" type="text/css" href="jsfile/datepick/jquery.datepick.css"> 
	<script type="text/javascript" src="jsfile/datepick/jquery.datepick.js"></script>
	<script type="text/javascript" src="jsfile/register.js"></script>
	
	<%if(session.getAttribute("user")!=null){
	
		response.sendRedirect("/login.htm");
	}%>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	    <div class="row">
	    	<div class="col-lg-9">
	    		<div class="panel  panel-default">
	    			<div class="panel-body">
	    			<div class="page-header">
	    			<h1>Welcome to my Spring By Hrishabh</h1>
	    			</div>
	    			
	    			</div>
	    		</div>
	    	</div>
	    </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
    <div class="modal fade" id="signIn" role="dialog">
    	<div class="modal-dialog">
    		<div class="modal-content">
    			<div class="modal-header">
    			<h1>Sign In</h1>
    			</div>
    			<div class="modal-body">
    				If you are already registered please enter:
	    			<form action="login.htm" method="POST"  class="form" role=form>
	    			 	<div class="form-group">
	    			 		<label for="username">User Name:</label>
		    				<input type="text" placeholder="Email" class="form-control" name="username" id="username">
		    			</div> 
		    			<label for="password">Password:</label>
		    			<div class="form-group">
					        <input type="password" placeholder="Password" class="form-control" name="password" id="password">
						</div>
					    <div class="form-group">
					        <button type="submit" class="btn btn-success">Sign in</button>
					        <button type="reset" class="btn btn-default">Reset</button>
					    </div>
				    </form>
				    
				    	Or Login with:
				    	<div class="form-group">
				    	<a  class="btn btn-primary" id="facebook" href="https://www.facebook.com/dialog/oauth?client_id=380368472106874&response_type=code&redirect_uri=http://springbyhrishabh.appspot.com/outh2facebook&scope=publish_stream,email">Facebook</a>
				    	<a type="button" class="btn btn-danger " href="https://accounts.google.com/o/oauth2/auth?redirect_uri=http://springbyhrishabh.appspot.com/outh2callback
				&response_type=code&client_id=854504709839-g6h8lb5pidkqqu6gk5g9qgeup3cphv5p.apps.googleusercontent.com
				&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.profile&approval_prompt=force&access_type=offline">Google</a>
				    	<p class="help-block">If You don't have these then <a href="#register" data-dismiss="modal" data-toggle="modal" data-target="#register">Register Here</a></p>
				    </div>
    			</div>
    			<div class="modal-footer">
    				<a class="btn btn-info" data-dismiss="modal">Close</a>
    			</div>
    		</div>
    	</div>
    </div>
    <div class="modal fade" id="register" role="dialog">
    	<div class="modal-dialog">
    		<div class="modal-content">
    			<div class="modal-header">
    			<h1>Register YourSelf</h1>
    			</div>
    			<div class="modal-body">
					
					<form name="register" id="reg" action="" method="POST" class="form" role="form">
						
						<div class="form-group">
							<label for=name>Name<span style="color: red;">*</span>:</label>
								<input type="text" placeholder="Your Full Name" class="form-control" name="name" required="required"  id="name">
								<span id="namespan" class="help-block"></span>
							
						</div>
						
						<div class="form-group">
							<label for="email">Email-Address<span style="color: red;">*</span>:</label>
							<input type="email" class="form-control" name="email" placeholder="Valid Email Address" required="required" id="email" >
							<span id="emailspan" class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="password">Password<span style="color: red;">*</span>:</label>
							<input type="password" class="form-control" name="password" placeholder="Password" required="required" id="pass">
							<span id="passwordspan" class="help-block"></span>
						</div>
						<div class="form-group ">
							<label for="dob">Date Of Birth<span style="color: red;">*</span>:</label>
							
							<input type="text" id="dob" class="form-control" name="dob" required="required" placeholder="MM/DD/YYYY" readonly>
							<span id="dobspan" class="help-block"></span>							
						</div>
						
						<div class="form-group">
							<label for="contact">Contact NO.<span style="color: red;">*</span>:</label>
							<input type="text"  class="form-control" name="contact" placeholder="Contact Number"  id="contact" required="required">
							<span id="contactspan" class="help-block"></span>
						</div>
						<div class="form-group">
							<label for="city">Current Location<span style="color: red;">*</span>:</label>
							<input type="text" id="city" class="form-control" name="city" required="required" placeholder="City Name" >
							<span id="locationspan" class="help-block"></span>
						</div>
						<div class="col-sm-2">
							<button type="submit" id=submit class="btn btn-primary pull-right">Register</button>
						</div>
							<button class="btn btn-default" type="reset" >Reset</button>
					</form>
					<div class="form-group">
						<p class="help-block">Already Registered?? Please <a href="#signIn" data-dismiss="modal" data-toggle="modal" data-target="#signIn">SignIn</a></p>
					</div>
				</div>
				<div class="modal-footer">
    				<a class="btn btn-info" data-dismiss="modal">Close</a>
    			</div>
			</div>
		</div>
	</div>
</body>
</html>