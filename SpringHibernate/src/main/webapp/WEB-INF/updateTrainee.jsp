<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<body>
   <form:form id="updateForm" modelAttribute="trainee" action="traineeUpdate" method="post" >

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
               <td>
                   <form:label path="firstName">First Name</form:label>
               </td>
               <td>
                   <form:input path="firstName" name="firstName ID" id="firstName" />
               </td>
           </tr>

           <tr>
               <td>
                   <form:button id="update" name="update">Update Trainee</form:button>
               </td>
           </tr>
           <tr></tr>
       </table>
   </form:form>
</body>
</html>