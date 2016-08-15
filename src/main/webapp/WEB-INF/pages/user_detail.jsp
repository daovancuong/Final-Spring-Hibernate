<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<body>
	<div class="container">
		<c:if test="${empty user}">
			<h1>user does not exits</h1>
		</c:if>
		<h1>${user.id}</h1>
		<h1>${user.name}</h1>
		<h1>${user.email}</h1>
		<h1>${user.address}</h1>
		<h1>${user.newsletter}</h1>
		<c:if test="${not empty user.framework}">
			<c:forEach items="${user.framework}" var="frame">
				<h2>${frame }</h2>
			</c:forEach>
		</c:if>


	</div>
</body>
</html>