<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            <h1>UPLOAD RESUME &nbsp;</h1>

        </div>
        <hr />
        <div class="row body">
            <form name="add_resource" method="POST"
                  action="<%=request.getContextPath()%>/add/Resource"
                  enctype="multipart/form-data">
                <ul>
                    <li>
                        <p class="left">
                            <label for="first_name">Select a Job Code:&nbsp; <span class="req">*</span></label>
                            <select style="margin: 0 0 0.5em 0;padding: 6px 10px;
    border-radius: 25px;
    border: 2px solid #006400;
    padding: 14px;
    width: 200px;
  color:black" name="jobCode">
                                <c:forEach items="${resources}" var="res">
                                    <option value="${res.jobcode}">${res.jobcode}</option>
                                </c:forEach>
                            </select>
                        </p>
                    </li>
                    <li>
                        <p class="left">
                            <label for="first_name">First Name <span class="req">*</span></label>
                            <input type="text" name="firstName" class="input-text"
                                   value="${firstName}" placeholder="John" />
                        </p>
                        <p class="pull-right">
                            <label for="middleName">Middle Name </label> <input type="text"
                                                                                name="middleName" value="${middleName}" class="input-text"
                                                                                placeholder="Smith" />
                        </p>
                    </li>


                    <li>
                        <p>
                            <label for="last_name">Last Name <span class="req">*</span></label>
                            <input type="text" name="lastName" class="input-text"
                                   value="${lastName}" placeholder="m" />
                        </p>
                        <p class="pull-right">
                            <label for="email">Email <span class="req">*</span></label> <input type="email" name="emailId" value="${emailId}"
                                                                                               class="input-text" placeholder="john.smith@gmail.com" />

                        </p>
                    </li>

                    <li>

                        <p>
                            <label for="phoneNumber">Phone Number </label> <input type="text" name="phone" value="${phone}"
                                                                                  class="input-text" placeholder="0123456789" />
                        </p>


                        <p class="pull-right">
                            <label for="technology">Technology <span class="req">*</span></label>
                            <input type="text" name="technology" value="${technology}"
                                   class="input-text" placeholder="Java,Tibco" />
                        </p>

                    </li>
                    <li>
                        <p>
                            <label for="noticePeriod">Notice Period</label> <input type="text" name="noticePeriod" value="${noticePeriod}"
                                                                                   class="input-text" placeholder="No of months" />

                        </p>
                        <p class="pull-right">
                            <label for="experienceLevel">Experience</label> <input type="text" name="experienceLevel" value="${experienceLevel}"
                                                                                   class="input-text" placeholder="Years of experience" />
                        </p>

                    </li>
                    <li>
                        <p>
                            <label for="currentSalary">Current Salary</label> <input type="text" name="currentSalary" value="${currentSalary}"
                                                                                     class="input-text" placeholder="Current Salary" />
                        </p>
                        <p class="pull-right">
                            <label for="expectedSalary">Expected Salary</label> <input type="text" name="expectedSalary" value="${expectedSalary}"
                                                                                       class="input-text" placeholder="Salary Expected" />
                        </p>

                    </li>
                    <li>
                        <p>
                            <label for="finalStatus">Status <span class="req">*</span></label>
                            <input type="text" name="finalStatus" value="${finalStatus}"
                                   placeholder="Status" class="input-text" />
                        </p>
                        <p class="pull-right" style="padding-top:20px">
                            <label for="resume">Resume <span class="req">*</span></label> <input type="file" name="resume" value="${resume}"
                                                                                                 style="padding-left: 5px" />

                        </p>


                    </li>

                    <li style="padding-left: 350px;
    width: 25px !important;">
                        <p class="pull-right">

                            <input class="btn btn-success" type="submit" value="Submit" />
                        </p>
                    </li>
                    <li><div class="divider"></div></li>

                </ul>

            </form>
        </div>
    </div>
</body>
</html>