<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">


<c:choose>
	<c:when test="${user.id}==0">
		<spring:url value="/users" var="userActionUrl"></spring:url>
	</c:when>
	<c:otherwise>
		<spring:url value="/users/update" var="userActionUrl"></spring:url>
	</c:otherwise>
</c:choose>
<form:form method="post" action="${userActionUrl}" modelAttribute="user">
	<form:hidden path="id" />

	<table id="table-1">
		<tbody>
			<tr>
				<td>Name</td>
				<spring:bind path="name">
					<td><form:input path="name" type="text" /> <form:errors
							path="name"></form:errors></td>
				</spring:bind>

			</tr>
			<spring:bind path="framework">
				<td><form:select path="framework" multiple="true"
						items="${skills}">
					</form:select></td>
			</spring:bind>
			<tr>
				<td>
					<button type="submit">submit</button>
				</td>
			</tr>
		</tbody>
	</table>
</form:form>
</html>