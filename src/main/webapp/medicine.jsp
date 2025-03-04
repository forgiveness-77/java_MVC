<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.pharmacy.models.Medicine" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<%
    if (session == null || session.getAttribute("email") == null) {
        response.sendRedirect("userLogin");
        return;
    }
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medicine Management</title>
    <link rel="stylesheet" href="styles.css"> <!-- External CSS file if needed -->
    <style>
        /* General Page Styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            padding: 20px;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        h2 {
            color: #444;
            margin-bottom: 10px;
        }

        /* Button Styling */
        button {
            background-color: #007bff;
            color: white;
            padding: 12px 20px;
            margin: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background 0.3s;
        }

        button a {
            text-decoration: none;
            color: white;
            font-weight: bold;
        }

        button:hover {
            background-color: #0056b3;
        }

        /* Form Styling */
        form {
            margin-top: 20px;
        }

        /* Logout Button */
        button[type="submit"] {
            background-color: #dc3545;
        }

        button[type="submit"]:hover {
            background-color: #b52a37;
        }
    </style>
</head>
<body>
    <h1>Medicine Management!</h1>

    <h2>Add Medicine</h2>
    <button><a href="addMed">Add Medicine</a></button>

    <h2>Get All Medicine</h2>
    <form>
        <button><a href="getMedicine">Get All Medicine</a></button>
    </form>

    <form action="<%= request.getContextPath() %>/logout" method="GET">
        <button type="submit">Logout</button>
    </form>
</body>
</html>
