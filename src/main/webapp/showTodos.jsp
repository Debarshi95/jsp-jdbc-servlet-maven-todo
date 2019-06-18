<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todos</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container w-50">
<h1 class="text-center">All Todos</h1>
<div>
   <h4 class="text-center">Add New Todo</h4>
   <form action="addTodo" method="post" class="text-center">
	 <input type="text" name="todo" class="form-control">
	 <button type="submit" class="btn btn-primary w-25 mt-3">ADD</button>
	</form>
	<c:forEach items="${list}" var="li">
		<div class="card justify-content-center align-items-center mt-3">
			<div class="card-body">
				<h4 class="card-title">
				${li.todo}
				</h4>
			</div>
			<a href="deleteTodo?id=${li.id}" class="btn btn-danger mb-3">DELETE</a>
		</div>
	</c:forEach>
</div>
</div>
</body>
</html>