   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Employees List</h1>
<table border="2" width="70%" cell-padding="2">
<tr><th>Id</th><th>First_Name</th><th>Last_Name</th><th>Reporting_Manager</th><th>Edit</th><th>Delete</th></tr>
   <c:forEach var="emp" items="${trainees}">
   <tr>
   <td>${emp.employeeId}</td>
   <td>${emp.firstName}</td>
   <td>${emp.lastName}</td>
   <td>${emp.reportingManager}</td>
   <td><a href="editTrainee/${emp.traineeId}">Edit</a></td>
   <td><a href="deleteTrainee/{emp.traineeId}">Delete</a></td>
   </tr>
   </c:forEach>
   </table>
   <br/>
   <a href="traineeRegister">Add new a trainee</a>