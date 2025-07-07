<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認</title>
</head>
<body>
	<h3>確認</h3>
	<table>
		<tr>
			<th>入力１：　</th>
			<td>${hogeForm1.input01}</td>
		</tr>
		<tr>
			<th>入力２：　</th>
			<td>${hogeForm2.input02}</td>
		</tr>
		<tr>
			<th>入力３：　</th>
			<td>${hogeForm3.input03}</td>
		</tr>
	</table>
	<br>
	<a href="<c:url value='/type02/complete'/>">登録</a>
</body>
</html>