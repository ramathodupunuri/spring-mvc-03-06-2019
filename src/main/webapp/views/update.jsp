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
<title>Genzeon Talent acquisition</title>
<body>
	<h3>Update User</h3>
	 <form method="POST" name="add_requirement" action="<%=request.getContextPath()%>/update">  
		
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
						<tr>
							<td> <input name="jobcode" value="${requirement.jobcode}" type="text"  /> </td>
							<td><input	name="experiencelevel" value="${requirement.experiencelevel}" type="text" /> </td>
							<td> <textarea name="skillset"><c:out value="${requirement.skillset}" /> </textarea></td>
							<td><input name="department" value="${requirement.department}" type="text"/></td>
							<td><input name="technology" value="${requirement.technology}" type="text"/></td>
							<td><input name="uploadedby" value="${requirement.uploadedby}" type="text"/></td>
							<td>
							<div class="sbt">
                       <input type="submit" value="submit" />
                    </div>
								 </td>
						</tr>
				</tbody>
			</table>
		
	</form>
</body>
</html>