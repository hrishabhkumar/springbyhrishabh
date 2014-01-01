<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <div class="navbar navbar-inverse navbar-static-top"> 
	    <div class="container">
		    <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
			    <span class="icon-bar"></span>
			    <span class="icon-bar"></span>
			    <span class="icon-bar"></span>
		    </button>
		  
		    <a href="/" class="navbar-brand">Spring By Hrishabh</a>
		    
		    <div class="collapse navbar-collapse navHeaderCollapse">
			    <ul class="nav navbar-nav navbar-right">
			    	<li><a href="#">Welcome
		    <%if(session.getAttribute("user")==null){ %>
		    	Guest
		    <%}else{ %>
		    	${user}
		    <%} %></a></li>
			    	<li class="active"><a href="/">Home</a></li>
			    	<%if(session.getAttribute("user")==null){ %><li ><a href="#signIn" data-toggle="modal">SignIn</a></li><%} %>
			    	<%if(session.getAttribute("user")==null){ %><li ><a href="#register" data-toggle="modal">Register</a></li><%} %>
				    <%if(session.getAttribute("user")!=null){ %><li><a href="/detail">Profile</a></li><%} %>
				   <%if(session.getAttribute("user")!=null){ %> <li><a href="/friend">Search</a></li><%} %>
				   <%if(session.getAttribute("user")!=null){ %> <li><a href="/logout">Logout</a></li><%} %>
			    </ul>
	    
	    	</div>
	    </div>
    </div>
     