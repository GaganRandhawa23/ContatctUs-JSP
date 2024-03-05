package com.contactus.dao;
import java.sql.*;
import com.contactus.model.User;

public class LoginDao {
    private static final String URL = "jdbc:postgresql://localhost:5432/ContactUs";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Randhawa@2024";

    public static boolean validAdmin(User user) throws ClassNotFoundException {
        String sql = "SELECT * FROM admin WHERE name=? AND password=?";
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
