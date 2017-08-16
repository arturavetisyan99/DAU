<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: avetisyan
  Date: 8/16/2017
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table.list
        {
            border-collapse:collapse;
            width: 40%;
        }
        table.list, table.list td, table.list th
        {
            border:1px solid gray;
            padding: 5px;
        }
    </style>
</head>
<body>

<h3>Retention <a href="./list">Back</a></h3>

<c:if  test="${!empty retention}">
    <table class="list">
        <tr>
            <th align="left">Name</th>
            <th align="left">Date</th>

        </tr>
        <c:forEach items="${retention}" var="r">
            <tr>
                <td>${r.id} </td>
                <td>${r.requestDate}</td>

            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
