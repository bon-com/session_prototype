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
	<c:url var="actionUrl" value="/type01/second-post" />
	<form:form modelAttribute="hogeForm" action="${actionUrl}">
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