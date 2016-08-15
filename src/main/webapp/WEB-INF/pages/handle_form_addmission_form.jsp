<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<meta charset="UTF-8">
</head>
<body>

	<h1>${title }</h1>
	<form:errors path="user.*"/>
	<form action="/Final-Spring-Hibernate/handleform/doform" method="post">
		<!-- <table>
			<tr>
				<td>firstname</td>
				<td><input type="text" name="firstname" /></td>
			</tr>
			<tr>
				<td>lastname</td>
				<td><input type="text" name="lastname" /></td>
			</tr>
		</table> -->
		<table>
			<tr>
				<td>name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>emai</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Skill Other</td>
				<td><select name="skillOther" multiple>
						<option value="javacore">java</option>
						<option value="php">php</option>
				</select></td>
			</tr>
			<tr>
				<td>city</td>
				<td><input type="text" name="address2.city" /></td>
			</tr>
			<tr>
				<td>street</td>
				<td><input type="text" name="address2.street" /></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input type="text" name="dateOfBirth" /></td>
			</tr>
			<tr>
				<td>mobine</td>
				<td><input type="text" name="mobiphone" /></td>
			</tr>
		</table>


		<button type="submit">submit</button>
	</form>
</body>
</html>