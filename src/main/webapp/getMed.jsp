<%@ page import="java.util.List" %>
<%@ page import="com.pharmacy.models.Medicine" %>
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
    <meta charset="UTF-8">
    <title>Medicine List</title>
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

        /* Table Styling */
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
            background: white;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background: #007bff;
            color: white;
        }

        tr:nth-child(even) {
            background: #f2f2f2;
        }

        /* Form Styling */
        form {
            display: inline;
            margin: 5px;
        }

        input {
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 8px 12px;
            cursor: pointer;
            border-radius: 5px;
            transition: background 0.3s;
        }

        button:hover {
            background-color: #218838;
        }

        /* Delete Button */
        button.delete-btn {
            background-color: #dc3545;
        }

        button.delete-btn:hover {
            background-color: #c82333;
        }

        /* Refresh Link */
        a {
            display: inline-block;
            background: #007bff;
            color: white;
            padding: 10px;
            margin-top: 15px;
            text-decoration: none;
            border-radius: 5px;
            transition: background 0.3s;
        }

        a:hover {
            background: #0056b3;
        }

        /* Logout Button */
        .logout {
            background-color: #ff6600;
            margin-top: 20px;
        }

        .logout:hover {
            background-color: #e65c00;
        }
    </style>
</head>
<body>
    <h2>Medicines List</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Stock</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Medicine> medicines = (List<Medicine>) request.getAttribute("medicines");
                if (medicines != null && !medicines.isEmpty()) {
                    for (Medicine med : medicines) {
            %>
            <tr>
                <td><%= med.getId() %></td>
                <td><%= med.getName() %></td>
                <td>$<%= med.getPrice() %></td>
                <td><%= med.getStock() %></td>
                <td>
                    <!-- Update Form -->
                    <form action="medicine" method="post">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="id" value="<%= med.getId() %>">
                        <input type="text" name="name" value="<%= med.getName() %>" required>
                        <input type="number" name="price" value="<%= med.getPrice() %>" step="0.01" required>
                        <input type="number" name="stock" value="<%= med.getStock() %>" required>
                        <button type="submit">Update</button>
                    </form>

                    <!-- Delete Form -->
                    <form action="medicine" method="post">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="<%= med.getId() %>">
                        <button type="submit" class="delete-btn" onclick="return confirm('Are you sure you want to delete this medicine?');">Delete</button>
                    </form>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="5">No medicines found.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <br>
    <a href="getMedicine">Refresh Medicine List</a>

    <form action="logout" method="GET" style="display: inline;">
        <button type="submit" class="logout">Logout</button>
    </form>
</body>
</html>
