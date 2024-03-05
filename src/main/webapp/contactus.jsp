<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        p {
            text-align: center;
            margin-bottom: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
            width: 50%;
            margin: 0 auto;
        }

        label {
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="email"],
        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 15px;
        }

        textarea {
            height: 150px;
        }

        input[type="submit"] {
            background-color: #0095ff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 15px;
        }
    </style>
</head>

<body>
    <h1>Contact Us</h1>
    <p>Please fill out this form to contact us.</p>
    <form action="contactus" method="post">
        <label for="fname">Your name:</label>
        <input type="text" id="fname" name="name" placeholder="Your name..">
        <label for="lname">Your email:</label>
        <input type="email" name="email" placeholder="example@example.com">
        <label for="subject">Message:</label>
        <textarea id="subject" name="message" style="height:200px"></textarea>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
