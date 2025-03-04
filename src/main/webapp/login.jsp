<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <style>
        /* Center everything */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
            margin: 0;
        }

        /* Language selection buttons */
        .language-selection {
            margin-bottom: 20px;
            text-align: center;
        }

        .language-selection button {
            background-color: #007bff;
            border: none;
            padding: 10px 20px;
            margin: 5px;
            border-radius: 5px;
            cursor: pointer;
        }

        .language-selection button a {
            text-decoration: none;
            color: white;
            font-weight: bold;
        }

        .language-selection button:hover {
            background-color: #0056b3;
        }

        /* Login form container */
        .form-container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 320px;
            text-align: center;
        }

        /* Input fields */
        input[type="email"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        /* Login button */
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            padding: 10px;
            border: none;
            width: 100%;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }

        /* Register link */
        .register-link {
            margin-top: 10px;
            font-size: 14px;
        }

        .register-link a {
            color: #007bff;
            text-decoration: none;
        }

        .register-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="language-selection">
        <h3>Hitamo Ururimi / Choose the language</h3>
        <button><a href="login_kiny.jsp">Ikinyarwanda</a></button>
        <button><a href="login.jsp">English</a></button>
    </div>

    <div class="form-container">
        <h2>Login</h2>
        <form action="login" method='POST'>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <input type="submit" value="Login">
        </form>

        <div class="register-link">
            No account? <a href="userRegister">Register</a>
        </div>
    </div>

</body>
</html>
