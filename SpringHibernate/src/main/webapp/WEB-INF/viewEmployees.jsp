<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

      <table border="2" width="70%">
      <tr><th>employeeId</th><th>employeeFirstName</th><th>employeeLastName</th></tr>
   <c:forEach var="employees" items="${list}" >
   <tr>
    <td>${employees.employeeId}</td><br>
    <td>${employees.employeeFirstName}</td><br>
    <td>${employees.employeeLastName}</td><br>
   </tr>
   </c:forEach>
    </table>
    <a href="index.jsp">Home</a>


