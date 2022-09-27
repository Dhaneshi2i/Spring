<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table border="2" width="70%" cell-padding="2">
<tr><th>Employee_Id</th><th>First_Name</th><th>Last_Name</th><th>Reporting_Manager</th></tr>
   <tr>
        <td>${trainee.employeeId}</td>
        <td>${trainee.firstName}</td>
         <td>${trainee.lastName}</td>
         <td>${trainee.reportingManager}</td>
   </tr>

   </table>
   <tr>
       <td><a href="index.jsp">Home</a>
       </td>
   </tr>