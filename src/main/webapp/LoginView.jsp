<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login - APEX store</title>
		<link rel="stylesheet" href="LoginView.css"> 
		
	</head>
	<body>
	
	<h1 class = "formatText">APEX STORE</h1>
	
	<div class="login">
		<h1>Login</h1>
		<!-- Login Form starts from here -->
   			 <form action = "log" method="POST">
    			<input type="text" name="uname" placeholder="Username" required="required" />
        		<input type="password" name="pword" placeholder="Password" required="required" />
        		<button type="submit" name="Login" class="btn btn-primary btn-block btn-large">LOGIN</button>
    		</form>
	</div>

	</body>
</html>