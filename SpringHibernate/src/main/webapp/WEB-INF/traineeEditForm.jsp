<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

        <h1>Edit Employee</h1>
       <form:form method="PUT" action="/springHibernate/editAndSaveTrainee">
        <table >
        <tr>
        <td></td>
         <td><form:hidden  path="traineeId" /></td>
         </tr>
         <tr>
          <td>First Name : </td>
          <td><form:input path="firstName"  /></td>
         </tr>
         <tr>
          <td>Last Name :</td>
          <td><form:input path="lastName" /></td>
         </tr>
         <tr>
          <td>Employee Id :</td>
          <td><form:input path="employeeId" /></td>
         </tr>
           <tr>
           <td>Reporting Manager:</td>
           <td><form:input path="reportingManager" /></td>
         </tr>

         <tr>
          <td> </td>
          <td><input type="submit" value="Edit Save" /></td>
         </tr>
        </table>
       </form:form>