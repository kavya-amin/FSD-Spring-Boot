<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>

<html>

<head>
	<title>List Employees</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>ERM - Employee Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Employee 
		
			<input type="button" value="Add Employee"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			-->
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Salary</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our employees -->
				<c:forEach var="tempEmployee" items="${employee}">
				
					<!-- construct an "update" link with employee id 
					<c:url var="updateLink" value="/employee/showFormForUpdate">
						<c:param name="employeeId" value="${tempEmployee.id}" />
					</c:url>			-->		

					<!-- construct an "delete" link with employee id 
					<c:url var="deleteLink" value="/employee/delete">
						<c:param name="employeeId" value="${tempEmployee.id}" />
					</c:url>		-->			
					
					
					<tr>
						<td> ${tempEmployee.firstName} </td>
						<td> ${tempEmployee.lastName} </td>
						<td> ${tempEmployee.salary} </td>
						<td><a href="#">Update</a></td>
						<!-- 
						<td>
							display the update link
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this Employee?'))) return false">Delete</a>
						</td>  -->
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>