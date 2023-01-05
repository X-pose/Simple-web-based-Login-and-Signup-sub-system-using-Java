package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.DatabaseOps;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get password and username from login.jsp
		String CFName = request.getParameter("CFName");
		String CLName = request.getParameter("CLName");
		String CAddress = request.getParameter("CAddress");
		String CGender = request.getParameter("CGender");
		String CPostcode = request.getParameter("CPostcode");
		String CContactNo = request.getParameter("CContactNo");
		String Susername = request.getParameter("Suname");
		String Spassword = request.getParameter("Spword");
		try {
			
			DatabaseOps dbOps = DatabaseOps.getInstance(); //Getting singleton DatabaseOps object
			
			int valid =  dbOps.signUpUser(CFName, CLName, CAddress, CGender, CPostcode, CContactNo, Susername, Spassword);
			System.out.println(valid);
			//validates whether signUpUser function executed properly. If succeed - valid = 2, If not- valid = 0
			if(valid > 0) {
				RequestDispatcher dis = request.getRequestDispatcher("LoginView.jsp"); // Try again page or msg	
			 	dis.forward(request, response);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
