<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Bahrini Mobile Store Application</title>
</head>
<body>
	<center>
		<h1>Mobiles Management</h1>
        <h2>
        	<a href="new">Add New Mobile</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Mobile</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Mobile</h2></caption>
            <tr>
                <th>ID</th>
                <th>Refrence</th>
                <th>Brand</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="mobile" items="${listMobile}">
                <tr>
                    <td><c:out value="${mobile.id}" /></td>
                    <td><c:out value="${mobile.title}" /></td>
                    <td><c:out value="${mobile.author}" /></td>
                    <td><c:out value="${mobile.price}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${mobile.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${mobile.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
