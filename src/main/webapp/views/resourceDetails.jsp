<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Genzeon Talent acquisition</title>
<link href="<%=request.getContextPath()%>/resources/resources.css"
	rel="stylesheet" />
<link href="addResource.css" rel="stylesheet" />
</head>
<body>


	<div class="container">
		<div class="row header" style="text-align: center; margin-top: 10px">
			<h1>Resource Details &nbsp;</h1>

		</div>
		<hr />
		<div class="row body">
			<form name="add_resource" method="POST"
				action="#"
				enctype="multipart/form-data">
				<ul>
					<li>
						<p class="left">
							<label for="first_name">Select a Job Code:&nbsp; <span
								class="req">*</span></label> <select
								style="margin: 0 0 0.5em 0; padding: 6px 10px; border-radius: 25px; border: 2px solid #006400; padding: 14px; width: 200px; color: black"
								name="jobCode">
									<option  selected="selected" value="${resourcevo.jobCode}">${resourcevo.jobCode}</option> 
							</select>
						</p>
					</li>
					<li>
						<p class="left">
							<label for="first_name">First Name <span class="req">*</span></label>
							<input type="text" name="firstName" class="input-text"
								value="${resourcevo.firstName}" placeholder="John" />
						</p>
						<p class="pull-right">
							<label for="middleName">Middle Name </label> <input type="text"
								name="middleName" value="${resourcevo.middleName}" class="input-text"
								placeholder="Smith" />
						</p>
					</li>


					<li>
						<p>
							<label for="last_name">Last Name <span class="req">*</span></label>
							<input type="text" name="lastName" class="input-text"
								value="${resourcevo.lastName}" placeholder="m" />
						</p>
						<p class="pull-right">
							<label for="email">Email <span class="req">*</span></label> <input
								type="email" name="emailId" value="${resourcevo.emailId}"
								class="input-text" placeholder="john.smith@gmail.com" />

						</p>
					</li>

					<li>

						<p>
							<label for="phoneNumber">Phone Number </label> <input type="text"
								name="phone" value="${resourcevo.phone}" class="input-text"
								placeholder="0123456789" />
						</p>


						<p class="pull-right">
							<label for="technology">Technology <span class="req">*</span></label>
							<input type="text" name="technology" value="${resourcevo.technology}"
								class="input-text" placeholder="Java,Tibco" />
						</p>

					</li>
					<li>
						<p>
							<label for="noticePeriod">Notice Period</label> <input
								type="text" name="noticePeriod" value="${resourcevo.noticePeriod}"
								class="input-text" placeholder="No of months" />

						</p>
						<p class="pull-right">
							<label for="experienceLevel">Experience</label> <input
								type="text" name="experienceLevel" value="${resourcevo.experienceLevel}"
								class="input-text" placeholder="Years of experience" />
						</p>

					</li>
					<li>
						<p>
							<label for="currentSalary">Current Salary</label> <input
								type="text" name="currentSalary" value="${resourcevo.currentSalary}"
								class="input-text" placeholder="Current Salary" />
						</p>
						<p class="pull-right">
							<label for="expectedSalary">Expected Salary</label> <input
								type="text" name="expectedSalary" value="${resourcevo.expectedSalary}"
								class="input-text" placeholder="Salary Expected" />
						</p>

					</li>
					<li>
						<p>
							<label for="finalStatus">Status <span class="req">*</span></label>
							<input type="text" name="finalStatus" value="${resourcevo.finalStatus}"
								placeholder="Status" class="input-text" />
						</p>
						<p class="pull-right" style="padding-top: 20px">
							<label for="resume">
							<a href="${resourcevo.resumePath}" style="padding-left: 10px" >Resume</a></label> 
						</p>
						
						<p class="pull-right" style="padding-top: 20px">
						<a href="<%=request.getContextPath()%>/addInterviewer/${resourcevo.jobCode}">Add interviewer</a>&nbsp; 
						</p>


					</li>

					<li><div class="divider"></div></li>

				</ul>

			</form>
		</div>
	</div>
</body>
</html>