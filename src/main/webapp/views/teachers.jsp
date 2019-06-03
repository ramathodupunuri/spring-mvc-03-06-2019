<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
#requirements {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#requirements td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#requirements tr:nth-child(even) {
	background-color: #f2f2f2;
}

#requirements tr:hover {
	background-color: #ddd;
}

#requirements th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>
<html>
<title>Spring MVC Zero XML Example</title>
<body>
	<h2>Spring MVC Zero XML Example</h2>
	<c:if test="${not empty msg}">
        ${msg}
    </c:if>
	<c:choose>
		<c:when test="${teachers != null}">
			<h3>List of Teachers</h3>
			<table id="requirements">
				<thead>
					<tr>
						<th>Jobcode</th>
						<th>ExperienceLevel</th>
						<th>SkillSet</th>
						<th>Department</th>
						<th>Technology</th>
						<th>uploadedBy</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="t" items="${teachers}">
						<tr>
							<td>${t.jobcode}</td>
							<td>${t.experiencelevel}</td>
							<td>${t.skillset}</td>
							<td>${t.department}</td>
							<td>${t.technology}</td>
							<td>${t.uploadedby}</td>
							<td><a
								href="<%=request.getContextPath()%>/update/teacher/${t.jobcode}">Update</a>
								&nbsp; <a
								href="<%=request.getContextPath()%>/delete/teacher/${t.jobcode}"
								onclick="return confirm('Do you really want to delete?')">Delete</a></td>
								 
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
        No User found in the DB!
        </c:otherwise>
	</c:choose>
</body>
</html>