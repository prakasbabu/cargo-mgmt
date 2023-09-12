<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cargo Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Cargo List</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Weight (kg)</th>
            <th>Volume (m³)</th>
            <th>Pickup Date</th>
            <th>Delivery Date</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cargoItem" items="${cargoList}">
            <tr>
                <td>${cargoItem.name}</td>
                <td>${cargoItem.description}</td>
                <td>${cargoItem.weight}</td>
                <td>${cargoItem.volume}</td>
                <td>${cargoItem.pickupDate}</td>
                <td>${cargoItem.deliveryDate}</td>
                <td>
                    <a href="/cargo-edit?cargoId=${cargoItem.cargoId}" class="btn btn-primary">Edit</a>
                    <a href="/cargo-delete?cargoId=${cargoItem.cargoId}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class = "container" mt-5>

${message}
<FORM> <INPUT TYPE="button" VALUE="Go Back" class="btn btn-danger" onClick="history.go(-1)"> </FORM>
</div>

 

</body>
</html>
