<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
     <script src="https://code.jquery.com/jquery.js"></script>
     <script src="js/bootstrap.min.js"></script>
     <script type="text/javascript">
     $(docoment).ready(function(){
    	 var pic='${pic}';
    	 alert(pic);
     });
     </script>
  </head>
  <body>
    <jsp:include page="header.jsp"></jsp:include>
    
    	<div id="imageCarousel" class="carousel slide">
	    	<ol class=carousel-indicators>
	    	<li data-target="#imageCarousel" data-slide-to="0" class="active"></li>
	    	<li data-target="#imageCarousel" data-slide-to="1"></li>
	    	<li data-target="#imageCarousel" data-slide-to="2"></li>
	    	<li data-target="#imageCarousel" data-slide-to="3"></li>
	    	<li data-target="#imageCarousel" data-slide-to="4"></li>
	    	<li data-target="#imageCarousel" data-slide-to="5"></li>
	    	<li data-target="#imageCarousel" data-slide-to="6"></li>
	    	<li data-target="#imageCarousel" data-slide-to="7"></li>
	    	<li data-target="#imageCarousel" data-slide-to="8"></li>
	    	<li data-target="#imageCarousel" data-slide-to="9"></li>
	    	</ol>
	    	<div class="carousel-inner" id=images>
	    		<div class="item active">
	    			<img alt="Hrishabh" src="images/hrishabh.jpg" class="img-responsive">
	    			<div class="carousel-caption"><h3>Hrishabh</h3></div>
	    		</div>
	    		<div class="item">
	    			<img alt="Vicky" src="images/hrishabh.jpg" class="img-responsive">
	    			<div class="carousel-caption"><h3>Vicky</h3></div>
	    		</div>
	    		<div class="item">
	    			<img alt="Shukla" src="images/hrishabh.jpg" class="img-responsive">
	    			<div class="carousel-caption"><h3>Shukla</h3></div>
	    		</div>
	    		<div class="item">
	    			<img alt="Kumar" src="images/hrishabh.jpg" class="img-responsive">
	    			<div class="carousel-caption"><h3>Hrishi</h3></div>
	    		</div>	    		
	    	</div>
	    	<a class="carousel-control left" href="#imageCarousel" data-slide="prev">
	    	<span class="icon-prev"></span>
	    	</a>
	    	<a class="carousel-control right" href="#imageCarousel" data-slide="next">
	    	<span class="icon-next"></span>
	    	</a>
    	</div>
    	
    	 <center><div class="container">
    	<div class="jumbotrons">
    	<h1>Welcome to Springs By Hrishabh.</h1>
    	</div>
    </div>
    </center>
    <div class="container">
    	<div class="row">
    		<div class="col-md-3">
    		<h1><a href="#"> Hrishabh Kumar Shukla</a></h1>
    		<p>sdhgjka sakldgjskl ahsgjkl hsjklgh sakldgh hsdgjk hjksadhg jk</p>
    		<a href="#" class="btn btn-default">Read More</a>
    		</div>
    		<div class="col-md-3">
    		<h1><a href="#"> Hrishabh Kumar Shukla</a></h1>
    		<p>sdhgjka sakldgjskl ahsgjkl hsjklgh sakldgh hsdgjk hjksadhg jk</p>
    		<a href="#" class="btn btn-default">Read More</a>
    		</div>
    		<div class="col-md-3">
    		<h1><a href="#"> Hrishabh Kumar Shukla</a></h1>
    		<p>sdhgjka sakldgjskl ahsgjkl hsjklgh sakldgh hsdgjk hjksadhg jk</p>
    		<a href="#" class="btn btn-default">Read More</a>
    		</div>
    		<div class="col-md-3">
    		<h1><a href="#"> Hrishabh Kumar Shukla</a></h1>
    		<p>sdhgjka sakldgjskl ahsgjkl hsjklgh sakldgh hsdgjk hjksadhg jk</p>
    		<a href="#" class="btn btn-default">Read More</a>
    		</div>
    	</div>
    </div>
    
	<div class="navbar navbar-default navbar-fixed-bottom">
		
		<div class="container">
			<p class="navbar-text">Hrishabh Shukla</p>
			<a href="#" class="navbar-button btn-danger btn pull-right">YouTube</a>
		</div>
	</div>
	
    <div class="modal fade" id="signIn" role="dialog">
    	<div class="modal-dialog">
    		<div class="modal-content">
    		<form action="#" class="form-horizontal">
    			<div class="modal-header">
    			<h1>Sign In</h1>
    			</div>
    			<div class="modal-body" >
    			<div class="form-group">
    			<div class="row">
	    			
	    			 <div class="col-sm-2">
	    				<input type="text" placeholder="Email" class="form-control">
	    			</div> 
	    			<div class="col-sm-3">
				        <input type="password" placeholder="Password" class="form-control">
				     </div>
				        <button type="submit" class="btn btn-success">Sign in</button>
				    </div> 
				   </div>
				    
    			</div>
    			 </form>
    			<div class="modal-footer">
    				<a class="btn btn-primary" data-dismiss="modal">Close</a>
    			</div>
    		</div>
    	</div>
    </div>
  </body>
</html>