<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cargo Home Page</title>
    <style>
        body {
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 50vh;
            margin: 0;
        }
        
        .button-container {
            text-align: center;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 60px;
        }

        .button:hover {
            background-color: #0056b3;
        }

        /* Add CSS styles for the links */
        a {
            font-size: 24px; /* Change the font size as desired */
            color: red; /* Change the text color to red */
        }
    </style>
</head>
<body>
<div class="container mt-1">
    <h1>Welcome to Cargo Module</h1>
    <br>

    <ul>
        <li><a href="/cargo-add">Add Cargo</a></li>
        <br><br><br><br>
        <li><a href="/cargo-view">View / Edit / Delete Cargo</a></li>
    </ul>
</div>
</body>
</html>
