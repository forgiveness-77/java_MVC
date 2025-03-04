<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Hitamo Ururimi / Choose the Language</title>
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

        /* Language Selection Buttons */
        .lang-buttons {
            margin: 15px;
        }

        .lang-buttons button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            margin: 5px;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s;
        }

        .lang-buttons button a {
            color: white;
            text-decoration: none;
        }

        .lang-buttons button:hover {
            background-color: #0056b3;
        }

        /* Form Styling */
        form {
            background: white;
            max-width: 350px;
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

        /* Submit Button */
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px;
            width: 100%;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }

        /* Register Link */
        a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>Hitamo Ururimi / Choose the Language</h2>
    <div class="lang-buttons">
        <button><a href="login_kiny.jsp">Ikinyarwanda</a></button>
        <button><a href="userLogin">English</a></button>
    </div>

    <form action="login" method='POST'>
        <label>Imeyiri:</label>
        <input type="email" name="email" required>

        <label>Ijambobanga:</label>
        <input type="password" name="password" required>

        <input type="submit" value="Emeza">
    </form>

    <p>Nta akawunti? <a href="register">Kora Insya</a></p>
</body>
</html>
