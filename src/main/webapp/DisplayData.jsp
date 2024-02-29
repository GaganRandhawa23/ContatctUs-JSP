<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Data</title>
</head>
<style>
table{
border-collapse:collapse;
}
th,td{
	border:1px solid black;
	padding: 10px;
}
</style>
<body>

<h2>User Data</h2>

<%
    String url = "jdbc:postgresql://localhost:5432/ContactUs";
    String username = "postgres";
    String password = "Randhawa@2024";

    try {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users ORDER BY status DESC");

%>
        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Message</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
<%
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String message = resultSet.getString("message");
                Boolean statusBool = resultSet.getBoolean("status");
                int id = resultSet.getInt("id");

                String status = (statusBool) ? "Active" : "Archived";
%>
                <tr>
                    <td><%= name %></td>
                    <td><%= email %></td>
                    <td><%= message %></td>
                    <td><%= status %></td>
                    <td>
                        <form action="ToggleStatus" method="post" style="display: inline;">
                            <input type="hidden" name="id" value="<%= id %>">
                            <input type="hidden" name="statusBool" value="<%= statusBool %>">
                            <input type="submit" value="Toggle Status">
                        </form>
                    </td>
                </tr>
<%
            }
%>
            </tbody>
        </table>

<%
        resultSet.close();
        statement.close();
        connection.close();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
%>

</body>
</html>
