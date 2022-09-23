<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
        </head>
        <body>
            <h2>Delete an employee</h2>
            <form:form id="regForm" modelAttribute="trainee" action="deleteEmployee" method="post" >

             <table align="center">
             <tr>
             <td>
             <form:label path="employeeId">employeeId</form:label>
               </td>
               <td>
              <form:input path="employeeId" name="employeeId" id="employeeId" />
              </td>
              </tr>
              <tr>
              <td></td>
              <td>
              <form:button id="remove" name="remove">Remove</form:button>
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
