<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Bahrini Mobiles Store Application</title>
</head>
<body>
	<center>
		<h1>Mobiles Management</h1>
        <h2>
        	<a href="new">Add New Mobiles</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Mobiles</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${mobile != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${mobile == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${mobile != null}">
            			Edit Mobile
            		</c:if>
            		<c:if test="${mobile == null}">
            			Add New Mobile
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${mobile != null}">
        			<input type="hidden" name="id" value="<c:out value='${mobile.mobile_id}' />" />
        		</c:if>            
            <tr>
                <th>Refernce: </th>
                <td>
                	<input type="text" name="refrence" size="45"
                			value="<c:out value='${mobile.refrence}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Brand: </th>
                <td>
                	<input type="text" name="brand" size="45"
                			value="<c:out value='${mobile.brand}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                	<input type="text" name="price" size="5"
                			value="<c:out value='${mobile.price}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
