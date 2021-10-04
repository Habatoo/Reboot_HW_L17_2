<%@page import="java.util.*" contentType="text/html" pageEncoding="utf-8" language="java" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Homework L17 P2</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>

<body>
    <form action="post">
    <input type="hidden" name="action" value="add">

    <label class="pad_top">FirstName:</label>
    <input type="text" name="userFirstName"/><br/>

    <label class="pad_top">LastName:</label>
    <input type="text" name="userLastName"/><br/>

    <input type="submit" value="submit"/>
    </form>

    <%
    Enumeration keys = session.getAttributeNames();
    while (keys.hasMoreElements()) {
        String key = (String) keys.nextElement();
        out.println("User FirstName: " + key + ", LastName: " + session.getValue(key) + "<br>");
    }
    %>
</body>

</html>
