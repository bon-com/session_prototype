<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力その１</title>
</head>
<body>
	<h3>入力その１</h3>
	<form:form modelAttribute="hogeForm1" action="${pageContext.request.contextPath}/type02/second-post">
		<table>
			<tr>
				<th>入力１</th>
				<td><form:input path="input01" /></td>
			</tr>
		</table>
		<br>
		<button type="submit" name="send">送信</button>
	</form:form>
</body>
</html>