<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome</title>

<%if(session.getAttribute("user")==null){
		response.sendRedirect("login.htm");
	}%> 
	<script src="jsfile/ui/jquery-1.9.1.js"></script>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
     <script src="js/bootstrap.min.js"></script>
     <script>
     $(document).ready(function(){
     if (!$('#home').hasClass('active')) {
 		$('#home').addClass('active');
 	}
     });
     </script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="row">
	<div class=".col-lg-4">
    	<div class="container">
    		<%if(session.getAttribute("user")!=null){ %>
		    	<img class="pull-left img-circle" alt="/img/default.jpg" src='${prof_pic}'style="width: 140px; height: 140px">
		    <%} %>
		</div>
    </div>
    </div>
    <div class="row">
	<div class="col-lg-8">
		<div class="container">
			<div class="form-horizontal" role="form">
				<div class="form-group">
		    		<label class="col-sm-2 control-label">FullName :</label>
					<div class="col-sm-10">
		     			<p class="form-control-static">${user}</p>
		     		</div>
		     	</div>
		     	<div class="form-group">
		    		<label class="col-sm-2 control-label">Email :</label>
					<div class="col-sm-10">
		     			<p class="form-control-static">${email}</p>
		     		</div>
		     	</div>
		     	<%if(session.getAttribute("loginCount")!=null){ %>
			     	<div class="form-group">
			    		<label class="col-sm-2 control-label">Login Count :</label>
						<div class="col-sm-10">
			     			<p class="form-control-static">${loginCount}</p>
			     		</div>
			     	</div>
				<%} %>
			</div>
		</div>
	</div>
	</div>	
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>