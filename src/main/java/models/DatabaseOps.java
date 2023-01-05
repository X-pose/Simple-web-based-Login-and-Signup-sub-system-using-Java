package models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DatabaseOps {
	
	private static String url = "jdbc:mysql://localhost:3306/Your_database_name";
	private static String user = "Your_database_username";
	private static String pass = "Your_DB_Password";
	
	/*Implementing Singleton design pattern to ensure only one instance of this class access the database driver 
	(To reduce resource usage when accessing external entities)*/
	
	//Singleton implementation starts here - Method -> Lazy-initialization
	private static DatabaseOps dbOps = null;
	
	private DatabaseOps() {}
	
	 public static DatabaseOps getInstance() {
	        if (dbOps == null) {
	        	dbOps = new DatabaseOps();
	        }
	        return dbOps;
	    }
	 
	//getUser function 
	public List<Customer> getUser(String userName){
		
		ArrayList<Customer> cus = new ArrayList<>();
		
		
		try {
			//creating database connection
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			//Retrieving user account
			String sql0 = "select * from Your_database_name.CustomerLogin where CUserName  = '"+userName+"'; ";
			ResultSet rs = stmt.executeQuery(sql0);
			
			//You must start the resultSet to use it
			if (rs.next()) {
				
				int cid = rs.getInt(1);
				String username = rs.getString(2);
				String passWord = rs.getString(3);
			
				String sql1 = "select * from Your_database_name.Customers where CID = "+ cid +";";
				ResultSet customerDetails = stmt.executeQuery(sql1);
				
				if(customerDetails.next()) {
					String CFName = customerDetails.getString(2);
					String CAddress = customerDetails.getString(5);
					String CPostCode = customerDetails.getString(7);
					Customer c = new Customer (cid , username ,passWord, CFName, CAddress, CPostCode );
					// customer login details are added into the array list
					cus.add(c);
				}
				else {
					//Use this part to show a proper error msg to indicate that data insertion was not successful 
				}
				customerDetails.close();
				
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return cus ;
	}
	
	//signUpUser function 
	public int signUpUser(String CFName, String CLName,String CAddress,String CGender,String CPostcode,String CContactNo,String Susername,String Spassword ){
		
		int validator = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			
			//database connection
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			
			//Gets max CID from Customer table. CRUD - READ happens here 
			String sql0 = "SELECT COUNT(CID) FROM Your_database_name.Customers;";
			ResultSet maxCID = stmt.executeQuery(sql0);
			if(maxCID.next()) {
			
				int newID = maxCID.getInt(1);
				newID += 1001; //Increments newCID by 1001(default starting number is 1000) to generate the new CID
				
				//Getting system time to store it in the database
				java.util.Date utilDate = new java.util.Date();
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				
				//Insert new user details to the database. CRUD - CREATE happens here
				String sql1 = "INSERT INTO Your_database_name.Customers VALUES ("+newID+",'"+ CFName +"','"+CLName+"','"+sqlDate+"','"+CAddress+"', '"+CGender+"','"+CPostcode+"'); ";
				String sql2 = "INSERT INTO Your_database_name.CustomerLogin VALUES ("+newID+",'"+ Susername+"', '"+Spassword+"')";
	
				int execute1 = stmt.executeUpdate(sql1);
				int execute2= stmt.executeUpdate(sql2);
				
				validator = execute1 + execute2;
			}
		//ResultSet rs2 = stmt.executeQuery(sql2);
		maxCID.close();
		stmt.close();
		con.close();
		
		}catch(Exception SIGN ) {
			SIGN.printStackTrace();
		}
		
		return validator;
		
	}

	

}
