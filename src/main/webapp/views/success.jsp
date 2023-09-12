<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html>
<html>
<head>

    <meta charset="ISO-8859-1">
    <title>Success Page</title>
</head>
<body>

<div class = "container" mt-5>

${message}
<br><br>
<FORM> <INPUT TYPE="button" VALUE="Go Back" class="btn btn-danger" onClick="history.go(-1)"> </FORM>
</div>

</body>
</html>