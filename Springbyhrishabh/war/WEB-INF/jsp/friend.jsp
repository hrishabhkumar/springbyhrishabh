<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<%if(session.getAttribute("user")==null){
		response.sendRedirect("/login.htm");
	}%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="jsfile/ui/jquery-1.9.1.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
     <script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="jsfile/friends.js"></script>
<title>friends</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
<!-- ################################# Container Start from here ############################### -->	
	<div class="container" >
		<h1>Search the people who are already on this site.</h1>
		
<!-- ######################### Taking Input for login ####################################### -->	
		
	<div>
	<form >
		<input type="text" id="search" name="search" placeholder="Search Friend"> 
		<button type="submit" id="seachButton">Search</button>
		</form>
	</div>
	</div>
<!-- ######################### Showing Results here ################################## -->	
	<div class="container">
	    <div class="row">
	    	<div class="col-lg-9">
	    		<div class="panel  panel-default">
	    			<div class="panel-body">
	    			<div class="page-header">
	    			
	    			</div>
	    				<div id="searchResult">
							<span></span>
						</div>
	    			</div>
	    		</div>
	    	</div>
	    </div>
    </div>
<!-- ######################### Container ends here ################################### -->		
	
<!-- ######################## Footer ############################################### -->	
<jsp:include page="footer.jsp"></jsp:include>	
	
	
</body>
</html>