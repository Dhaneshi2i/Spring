<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table border="2" width="70%" cell-padding="2">
<tr><th>Employee_Id</th><th>First_Name</th><th>Last_Name</th><th>Projects_worked</th></tr>
   <tr>
        <td>${trainer.employeeId}</td>
        <td>${trainer.firstName}</td>
         <td>${trainer.lastName}</td>
         <td>${trainer.projectsWorked}</td>
   </tr>

   </table>
   <tr>
       <td><a href="index.jsp">Home</a>
       </td>
   </tr>