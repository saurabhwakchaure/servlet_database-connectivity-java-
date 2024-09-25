<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        width: 350px;
        text-align: center;
    }

    h1 {
        color: #333;
        font-size: 24px;
        margin-bottom: 10px;
    }

    h2 {
        color: #555;
        font-size: 18px;
        margin-bottom: 20px;
    }

    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 8px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    form {
        margin-top: 15px;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Student Registration</h1>
        <h2>Please fill in the form below</h2>
        <form action="add_stud_details" method="post">
            Enter Student Name:<br>
            <input type="text" name="stud_name" required><br><br>
            Enter Student Age:<br>
            <input type="text" name="stud_age" required><br><br>
            Enter Student Email:<br>
            <input type="text" name="stud_email" required><br><br>
            Enter Password:<br>
            <input type="password" name="password" required><br><br>
            <input type="submit" name="Register" value="Register">
        </form>
    </div>
</body>
</html>
