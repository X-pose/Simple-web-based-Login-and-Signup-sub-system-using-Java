package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Customer;
import models.DatabaseOps;


@WebServlet("/customerLoginservlet")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get password and username from loginView.jsp
		String username = request.getParameter("uname");
		String password = request.getParameter("pword");
		try {
			
			DatabaseOps dbOps = DatabaseOps.getInstance(); //Getting singleton DatabaseOps object
			
			List<Customer> cusDetails = dbOps.getUser(username);
		
			//User Validation - Checks whether user is found on the database
			if(!cusDetails.isEmpty()) {
				
				//Create a session for the user
				HttpSession session = request.getSession(true);
				session.setAttribute("custID",cusDetails.get(0).getCid()); //Get customer ID
				session.setAttribute("custObj",cusDetails.get(0)); //Get customer as an Object
				
				//If password matches - Redirect to userAccount page
				// Using string.equal() to compare the string values instead of reference
				 if(password.equals(cusDetails.get(0).getPassword())) {
					
					 RequestDispatcher dis = request.getRequestDispatcher("Product.jsp");	
						dis.forward(request, response);	
				 }
				 else {
					 RequestDispatcher dis = request.getRequestDispatcher("LoginView.jsp"); // Try again page or Suitable error msg can be shown with this part. 	
					 	dis.forward(request, response);
				 }
			}
			else {
				//If user is not found - Redirect to sign up page
				RequestDispatcher dis = request.getRequestDispatcher("SignUpView.jsp");	//User is not found - redirects to Sign up page
				dis.forward(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				
	}

}
