<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Register</title>
    <style>
        /* Center the form */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        /* Form container */
        .form-container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 320px;
            text-align: center;
        }

        /* Input fields */
        input[type="text"], input[type="email"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        /* Submit button */
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

        /* Labels */
        label {
            font-weight: bold;
            display: block;
            text-align: left;
            margin-bottom: 5px;
        }
    </style>
</head>
<body>

    <div class="form-container">
        <h2>Register</h2>
        <form action="register" method="POST">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <input type="submit" value="Register">
        </form>
    </div>

</body>
</html>
