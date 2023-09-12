
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cargo Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1>Cargo Management</h1>

    <!-- Create/Update Cargo Form -->
    <form method="post" action="/createCargo">
        <input type="hidden" name="cargoId" value="${cargoDto.id}">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${cargoDto.name}" required>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea class="form-control" id="description" name="description">${cargoDto.description}</textarea>
        </div>
        <div class="form-group">
            <label for="weight">Weight (kg)</label>
            <input type="number" class="form-control" id="weight" name="weight" value="${cargoDto.weight}" required>
        </div>
        <div class="form-group">
            <label for="volume">Volume (m³)</label>
            <input type="number" class="form-control" id="volume" name="volume" value="${cargoDto.volume}" required>
        </div>
        <div class="form-group">
            <label for="pickupDate">Pickup Date</label>
            <input type="date" class="form-control" id="pickupDate" name="pickupDate" value="${cargoDto.pickupDate}">
        </div>
        <div class="form-group">
            <label for="deliveryDate">Delivery Date</label>
            <input type="date" class="form-control" id="deliveryDate" name="deliveryDate" value="${cargoDto.deliveryDate}">
        </div>

        <button type="submit" class="btn btn-primary">Save</button> <FORM> <INPUT TYPE="button" VALUE="Go Back" class="btn btn-danger" onClick="history.go(-1)"> </FORM>
    </form>

      
</div>
</body>
</html>
