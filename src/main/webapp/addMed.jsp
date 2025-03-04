<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<%
    if (session == null || session.getAttribute("email") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Add Medicine</title>
    <style>
        /* General Page Styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            padding: 20px;
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        /* Form Styling */
        form {
            background: white;
            max-width: 400px;
            margin: auto;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        /* Buttons */
        button {
            display: block;
            width: 100%;
            text-decoration: none;
            color: white;
            background-color: #007bff;
            padding: 10px;
            margin: 10px 0;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s;
        }

        button:hover {
            background-color: #0056b3;
        }

        /* Logout Button */
        .logout-btn {
            background-color: #dc3545;
        }

        .logout-btn:hover {
            background-color: #b52a37;
        }
    </style>
</head>
<body>
    <h2>Add Medicine</h2>
    <form action="addMedicine" method="POST">
        <label>Name:</label>
        <input type="text" name="name" required>

        <label>Price:</label>
        <input type="number" name="price" step="0.01" required>

        <label>Stock:</label>
        <input type="number" name="stock" required>

        <button type="submit">Add Medicine</button>
    </form>

    <form action="<%= request.getContextPath() %>/logout" method="GET">
        <button type="submit" class="logout-btn">Logout</button>
    </form>
</body>
</html>