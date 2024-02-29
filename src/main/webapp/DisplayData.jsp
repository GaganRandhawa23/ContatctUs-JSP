<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Data</title>
</head>
<body>

<h2>User Data</h2>

<%
    String url = "jdbc:postgresql://localhost:5432/ContactUs";
    String username = "postgres";
    String password = "Randhawa@2024";

    try {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String message = resultSet.getString("message");

            // Display user data on the page
            out.println("<p>Name: " + name + "<br>Email: " + email + "<br>Message: " + message + "</p>");
        }

        resultSet.close();
        statement.close();
        connection.close();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
%>

</body>
</html>
