<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

	<title>
		Books collection
	</title>
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>

	<div id="wrappe">
		<div id="header">
			<h2>Book Collection</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<input type="button" value="Add Book" 
					onclick="window.location.href='showFormForAdd' ; return false;" 
					class="add-button" />
		
			<table>
				<tr>
					<th>Title</th>
					<th>Author</th>
					<th>ISBN</th>
				</tr>
				
				<c:choose>
					<c:when test="${not empty books}">
						<c:forEach items="${books}" var="book" varStatus="status">
							
							<tr>
								<td>${book.title}</td>
								<td>${book.author}</td>
								<td>${book.isbn}</td>
							</tr>
							 
						</c:forEach>
						</table>

					</c:when>
					<c:otherwise>
						</table>
						<br/></br>
						<h2 class="norecords">No records</h2>

					</c:otherwise>	
				</c:choose>
			
		
		</div>
	</div>
	

</body>
</html>