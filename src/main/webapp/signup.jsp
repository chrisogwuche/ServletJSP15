<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 3/22/2023
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signup</title>
</head>
<body>
<form action="signup" method="post">
    First name: <input name="product_name" type="text">
    Lastname: <input name="price" type="text">
    password: <input name="quantity" type="text">
    <button>Submit</button>

    <div>
        <%
            PrintWriter printWriter = new PrintWriter(System.out);
            if(request.getAttribute("status").equals("success")){
            printWriter.print("Successful");
            }
        %>
    </div>
</form>




</body>
</html>
