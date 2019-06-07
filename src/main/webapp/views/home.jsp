<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>registration page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
  
  <style>
	.navbar-nav > li{
		float:right;
		padding-left:10px;
		padding-right:10px;
	}
    
  </style>

</head>
<body>


<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

<a class="navbar-brand" href="#">
    <img src="<%=request.getContextPath()%>/images/genzeon.jpg" alt="Logo" style="width:40px;">
  </a>
  
  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    
	
	<ul class="navbar-nav ml-auto">
    <li class="nav-item">
      <a class="nav-link" data-toggle="modal" data-target="#signIn">Sign In</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="modal" data-target="#signUp">Sign Up</a>
    </li>
    
  </ul>
    
  </div> 
  

  </nav>
<br>




<!-- The Modal -->
  <div class="modal fade" id="signIn">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Sign In</h4>
          <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
			<form action="OLXController" method="post">
				<div class="form-group">					
					<input type="hidden" class="form-control" id="action" name="action" value="login">
				</div>
				<div class="form-group">
					<label for="user_name">User name:</label>
					<input type="text" class="form-control" id="user_name" name="user_name">
				</div>
				<div class="form-group">
					<label for="user_password">Password:</label>
					<input type="password" class="form-control" id="user_password" name="user_password">
				</div>
				
				
				
				<br>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
        </div>
        
        
        
      </div>
    </div>
  </div>


  <!-- The Modal -->
  <div class="modal fade" id="signUp">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Registration form</h4>
          <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
			<form action="OLXController">
				<div class="form-group">					
					<input type="hidden" class="form-control" id="action" name="action" value="user_registration">
				</div>
				<div class="form-group">
					<label for="first_name">First Name:</label>
					<input type="text" class="form-control" id="first_name" name="first_name">
				</div>
				<div class="form-group">
					<label for="middle_name">Middle Name:</label>
					<input type="text" class="form-control" id="middle_name" name="middle_name">
				</div>
				<div class="form-group">
					<label for="last_name">Last Name:</label>
					<input type="text" class="form-control" id="last_name" name="last_name">
				</div>
				<div class="form-group">
					<label for="user_name">User Name:</label>
					<input type="text" class="form-control" id="user_name" name="user_name">
				</div>
				<div class="form-group">
					<label for="password">Password:</label>
					<input type="password" class="form-control" id="password" name="password">
				</div>
				<div class="custom-control custom-checkbox">
  <input type="checkbox" class="custom-control-input" id="defaultChecked2" >
  <label class="custom-control-label" for="defaultChecked2">IsAdmin</label>
</div><br>
				<div class="form-group">
					<label for="mgr_id">MgrId:</label>
					<input type="text" class="form-control" id="mgr_id" name="mgr_id">
				</div>
				<div class="form-group">
					<label for="email">Email:</label>
					<input type="email" class="form-control" id="email" name="email">
				</div>
								
				
						
				<br>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
        </div>
        
        
      </div>
    </div>
  </div>

</body>
</html>