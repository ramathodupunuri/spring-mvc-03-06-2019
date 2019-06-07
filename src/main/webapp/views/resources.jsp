<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<html>

<head>
<title>Genzeon Talent acquisition</title>
<style>
#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>

	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${resources != null}">
			<h3>List of Resources</h3>
			<table id="customers">

				<thead>

					<tr>

						<th>JobCode</th>

						<th>FirstName</th>

						<th>EmailId</th>

						<th>Technology</th>

						<th>Resume</th>

						<th>FinalStatus</th>
						<th></th>
					</tr>

				</thead>

				<tbody>

					<c:forEach var="resource" items="${resources}">

						<tr>

							<td>${resource.jobCode}</td>

							<td>${resource.firstName}</td>

							<td>${resource.emailId}</td>

							<td>${resource.technology}</td>

							<td><p>
									<a href="${resource.resumePath}">resume</a>
								</p></td>

							<td>${resource.finalStatus}</td>



							<td><a href="<%=request.getContextPath()%>/details/${resource.jobCode}">Details</a>&nbsp;

								&nbsp; <a href="<%=request.getContextPath()%>/deleteResource/${resource.jobCode}" onclick="return confirm('Do you really want to delete?')">Delete</a>
							</td>



						</tr>

					</c:forEach>

				</tbody>

			</table>
		</c:when>
		<c:otherwise>
        No Resources found.
        </c:otherwise>
	</c:choose>
</body>
</html>