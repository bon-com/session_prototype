<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力その２</title>
</head>
<body>
	<h3>入力その２</h3>
	<c:url var="actionUrl" value="/type01/third-post" />
	<form:form modelAttribute="hogeForm" action="${actionUrl}">
		<table>
			<tr>
				<th>入力２</th>
				<td><form:input path="input02" /></td>
			</tr>
		</table>
		<br>
		<button type="submit" name="send">送信</button>
	</form:form>
</body>
</html>