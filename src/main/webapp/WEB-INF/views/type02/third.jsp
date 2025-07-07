<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力その３</title>
</head>
<body>
	<h3>入力その３</h3>
	<form:form modelAttribute="hogeForm3" action="${pageContext.request.contextPath}/type02/confirm-post">
		<table>
			<tr>
				<th>入力３</th>
				<td><form:input path="input03" /></td>
			</tr>
		</table>
		<br>
		<button type="submit" name="send">送信</button>
	</form:form>
</body>
</html>