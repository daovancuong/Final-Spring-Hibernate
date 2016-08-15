<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
    uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<style>
  .error-message {
    font-size:90%;
    font-style:italic;
    color:red;
  }
</style>
</head>
<body>
    <jsp:include page="_menu.jsp" />
    
    <h1>Register</h1>
 
    <form:form modelAttribute="user" method="POST">
        <form:hidden path="id" />
        <form:hidden path="signInProvider" />  
        <table border="0">
             
            <tr>
                <td>Name</td>
                <td><form:input path="name" /></td>
                <td><form:errors path="name" class="error-message" /></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><form:input path="email" /></td>
                <td><form:errors path="email" class="error-message" /></td>
            </tr>
           
            <tr>
                <td></td>
                <td><input type="submit" value="Submit" /></td>
                <td></td>
            </tr>
        </table>
 
 
 
    </form:form>
    <div class="error-message">${errorMessage}</div>
</body>
</html>