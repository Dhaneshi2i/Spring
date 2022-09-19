<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
        </head>

        <body>
            <form:form id="regForm" modelAttribute="employee" action="registerProcess" method="post">

                <table align="center">
                    <tr>
                        <td>
                            <form:label path="firstName">FirstName</form:label>
                        </td>
                        <td>
                            <form:input path="firstName" name="firstName" id="firstName" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="lastName">LastName</form:label>
                        </td>
                        <td>
                            <form:input path="lastName" name="lastName" id="lastName" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="employeeId">EmployeeId</form:label>
                        </td>
                        <td>
                            <form:input path="employeeId" name="employeeId" id="employeeId" />
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <form:button id="register" name="register">Register</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td></td>
                        <td><a href="index.jsp">Home</a>
                        </td>
                    </tr>
                </table>
            </form:form>

        </body>

        </html>