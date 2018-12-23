<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

	<title>
		Add Book
	</title>
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-book-style.css">

</head>
<body>

	<div id="wrappe">
		<div id="header">
			<h2>Book Collection</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add book</h3>
		<form:form action="addBook" modelAttribute="book" method="POST">
			<table>
				<tBody>
					<tr>
						<td><label>Title:</label></td>
						<td><form:input path="title" /></td>
					</tr>
					<tr>
						<td><label>Author:</label></td>
						<td><form:input path="author" /><form:errors path="author" cssClass="error"/></td>
					</tr>
					<tr>
						<td><label>ISBN:</label></td>
						<td><form:input path="isbn" /><form:errors path="isbn" cssClass="error"/></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Add" class="save"/></td>
					</tr>
				</tBody>
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		<p>
			 <a href="${pageContext.request.contextPath}/customer/getAllBooks">Back to list</a>
		</p>
	</div>
	

</body>
</html>