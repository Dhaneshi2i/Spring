<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
   <form action="traineeAssociation">
   Enter the traineeId <input type="text" name ="traineeEmployeeId" /><br>
   Enter the trainerId <input type="text" name = "trainerEmployeeId" /><br>
   <button>ASSOCIATE</button>
   </form>
</body>
</html>