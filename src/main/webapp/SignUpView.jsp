<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="utf-8">
		<title>SignUp - APEX store</title>
		<link href="SignUpView.css" type="text/css" rel="stylesheet">
		<link rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	</head>

	<body>
		<h1 class="formatText">Sign up Form</h1>
		<div class="container">
			<!-- SignUp Form starts from here --------------------------------------------------------->
			<form action="sign" method="post" autocomplete="on">
				<!--First name-->
				<div class="box">
					<label for="firstName" class="fl fontLabel"> First Name: </label>
					<div class="new iconBox">
						<i class="fa fa-user" aria-hidden="true"></i>
					</div>

					<div class="fr">
						<input type="text" name="CFName" placeholder="First Name" class="textBox" autofocus="on"
							required>
					</div>
					<div class="clr"></div>
				</div>
				<!--First name------------------------------------------------------------------------->


				<!--Second name------------------------------------------------------------------------>
				<div class="box">
					<label for="secondName" class="fl fontLabel"> Last Name: </label>
					<div class="fl iconBox"><i class="fa fa-user" aria-hidden="true"></i></div>
					<div class="fr">
						<input type="text" required name="CLName" placeholder="Last Name" class="textBox">
					</div>
					<div class="clr"></div>
				</div>
				<!--Second name------------------------------------------------------------------------->

				<!-- Address --------------------------------------------------------------------------->
				<div class="box">
					<label for="Address" class="fl fontLabel"> Address :</label>
					<div class="new iconBox">
						<i class="fa fa-user" aria-hidden="true"></i>
					</div>
					<div class="fr">
						<input type="text" name="CAddress" placeholder="Address" class="textBox" autofocus="on"
							required>
					</div>
					<div class="clr"></div>
				</div>
				<!-- Address ---------------------------------------------------------------------------->

				<!-- Postal code ------------------------------------------------------------------------>
				<div class="box">
					<label for="PostCode" class="fl fontLabel"> Postal Code :</label>
					<div class="new iconBox">
						<i class="fa fa-user" aria-hidden="true"></i>
					</div>
					<div class="fr">
						<input type="text" name="CPostcode" placeholder="Postal Code" class="textBox" autofocus="on"
							required>
					</div>
					<div class="clr"></div>
				</div>
				<!-- Postal code ------------------------------------------------------------------------>

				<!---Phone No.--------------------------------------------------------------------------->
				<div class="box">
					<label for="phone" class="fl fontLabel"> Phone No.: </label>
					<div class="fl iconBox"><i class="fa fa-phone-square" aria-hidden="true"></i></div>
					<div class="fr">
						<input type="text" required name="CContactNo" maxlength="10" placeholder="Phone No."
							class="textBox"> <!-- Contact number front-end validation -->
					</div>
					<div class="clr"></div>
				</div>
				<!---Phone No.--------------------------------------------------------------------------->

				<!--User name---------------------------------------------------------------------------->
				<div class="box">
					<label for="UserName" class="fl fontLabel"> User Name: </label>
					<div class="fl iconBox"><i class="fa fa-user" aria-hidden="true"></i></div>
					<div class="fr">
						<input type="text" required name="Suname" placeholder="User Name" class="textBox">
					</div>
					<div class="clr"></div>
				</div>
				<!--User name----------------------------------------------------------------------------->

				<!---Password----------------------------------------------------------------------------->
				<div class="box">
					<label for="password" class="fl fontLabel"> Password </label>
					<div class="fl iconBox"><i class="fa fa-key" aria-hidden="true"></i></div>
					<div class="fr">
						<input type="Password" required name="Spword" placeholder="Password" class="textBox">
					</div>
					<div class="clr"></div>
				</div>
				<!---Password----------------------------------------------------------------------------->

				<!---Gender------------------------------------------------------------------------------->
				<div class="box radio">
					<label for="gender" class="fl fontLabel"> Gender: </label>
					<input type="radio" name="CGender" value="M" required> Male &nbsp; &nbsp; &nbsp; &nbsp;
					<input type="radio" name="CGender" value="F" required> Female
				</div>
				<!---Gender--------------------------------------------------------------------------------->

				<!--Terms and Conditions-------------------------------------------------------------------->
				<div class="box terms">
					<input type="checkbox" name="Terms" required> &nbsp; I accept the terms and conditions
				</div>
				<!--Terms and Conditions-------------------------------------------------------------------->

				<!---Submit Button-------------------------------------------------------------------->
				<div class="box" style="background: #2d3e3f">
					<input type="submit" name="submit" class="submit" value="Sign Up">
				</div>
				<!---Submit Button------------------------------------------------------------------->

			</form>
			<!--SignUp Form ends here --------------------------------------------------------------->
		</div>
	</body>

	</html>