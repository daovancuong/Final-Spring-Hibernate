<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>
	<h2>Page3Form.jsp</h2>

	<form:form method="POST" commandName="command">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>Remark :</td>
				<td><form:input path="address" /></td>
				<td><form:errors path="address" cssClass="error" /></td>
			</tr>
			<tr>
			<tr>
				<td colspan="3"><input type="submit" value="Previous"
					name="_target1" /> <input type="submit" value="Finish"
					name="_finish" /> <input type="submit" value="Cancel"
					name="_cancel" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
5. ResultForm.jsp Display all the form’s data which collected from the
previous 3 pages.

<html>
<body>
	<h2>ResultForm.jsp</h2>

	<table>
		<tr>
			<td>UserName :</td>
			<td>${user.userName}</td>
		</tr>
		<tr>
			<td>Password :</td>
			<td>${user.password}</td>
		</tr>
		<tr>
			<td>Remark :</td>
			<td>${user.remark}</td>
		</tr>
	</table>

</body>
</html>