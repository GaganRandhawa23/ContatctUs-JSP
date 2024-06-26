<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }

        header {
            padding: 20px;
            background-color: #0095ff;
            height: 4em;
            text-align: center;
            color: white;
        }

        .form-container {
            max-width: 50%;
            margin: 80px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .contact-form h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-container label {
            display: block;
            font-weight: bold;
        }

        .form-container label::after {
            content: " *";
            color: red;
        }

        .form-container input,
        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            margin-bottom: 15px;
            resize: vertical;
        }

        .submit-button {
            padding: 10px 20px;
            background-color: #0095ff;
            border: none;
            color: white;
            border-radius: 5px;
            font-size: 1rem;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to Login Page</h1>
    </header>

    <div class="form-container">
        <h2>Enter your details here</h2>
        <form action="login" method="post">

            <label for="name">Name</label>
            <input type="text" id="name" name="name" required>

            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>

            <button type="submit" class="submit-button">Login</button>

        </form>
    </div>
</body>
</html>
