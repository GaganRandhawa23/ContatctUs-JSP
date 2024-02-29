package com.contactus.Dao;
import java.sql.*;


import com.contactus.pojo.Admin;

public class AdminDao {
	
	public static boolean validAdmin(Admin admin) throws ClassNotFoundException {
        String sql = "SELECT * FROM admin WHERE name=? AND password=?";
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/ContactUs";
        String username = "postgres";
        String password = "Randhawa@2024";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Admin found in the database
                String dbName = resultSet.getString("name");
                String dbPassword = resultSet.getString("password");

                // Check if the retrieved credentials match the Admin object
                if (dbName.equals(admin.getName()) && dbPassword.equals(admin.getPassword())) {
                    return true;  // Credentials match
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	

}
