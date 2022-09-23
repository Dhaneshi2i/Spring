   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Employees List</h1>
<table border="2" width="70%" cell-padding="2">
<tr><th>Id</th><th>First_Name</th><th>Last_Name</th><th>Projects_Worked</th><th>Edit</th><th>Delete</th></tr>
   <c:forEach var="emp" items="${trainers}">
   <tr>
   <td>${emp.employeeId}</td>
   <td>${emp.firstName}</td>
   <td>${emp.lastName}</td>
   <td>${emp.projectsWorked}</td>
   <td><a href="editTrainer/${emp.trainer_id}">Edit</a></td>
   <td><a href="deleteTrainer/${emp.trainer_id}">Delete</a></td>
   </tr>
   </c:forEach>
   </table>
   <br/>
   <a href="trainerRegister">Add new a trainer</a>