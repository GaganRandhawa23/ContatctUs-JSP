package com.contactus.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.contactus.model.Request;
public class RequestDao {
	
   final static String url = "jdbc:postgresql://localhost:5432/ContactUs";
   final static String username = "postgres";
   final static String password = "Randhawa@2024";
    
	public static void saveRequest(Request request) 
	{
		String sql = "INSERT INTO users (name, email, message) values(?,?,?)";

	    try  {
	    	Class.forName("org.postgresql.Driver");
	    	Connection connection = DriverManager.getConnection(url, username, password);
	    	PreparedStatement statement = connection.prepareStatement(sql);
            
	    	statement.setString(1, request.getName());
			statement.setString(2, request.getEmail());
			statement.setString(3, request.getMessage());
			System.out.print(request.getName());
			ResultSet rs = statement.executeQuery();
			rs.next();
	    	
	    }catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static List<Request> fetchRequests(Boolean isActive) {
	    List<Request> requests = new ArrayList<>();
	    String query = "SELECT * FROM users WHERE status = " + isActive;

	    try {
	        Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection(url, username, password);
	        Statement st = con.createStatement();
	        ResultSet resultSet = st.executeQuery(query);

	        while (resultSet.next()) {
	            Request req = new Request();
		 		req.setName(resultSet.getString(1));
		 		req.setEmail(resultSet.getString(2));
		 		req.setMessage(resultSet.getString(3));
		 		req.setStatus(resultSet.getBoolean(4));
		 		req.setId(resultSet.getInt(5));

	            requests.add(req);
	        }
	        resultSet.close();
	        st.close();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return requests;
	}
	
	public static void toggleUserStatus(int id, boolean currentStatus) {
        String sql = "UPDATE users SET status = ? WHERE id = ?";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            boolean newStatus = !currentStatus; 
            preparedStatement.setBoolean(1, newStatus);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	}
}
