<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>セッション参照確認01</title>
</head>
<body>
	<h3>HTTPセッションの利用</h3>
	<ul>
		<li>確認その１ー１（@ModelAttributeにフォーム指定）　<a href="<c:url value='/test/test01-1'/>">こちら</a></li>
	</ul>
	<ul>
		<li>確認その１－２（@SessionAttributeにフォーム指定）　<a href="<c:url value='/test/test01-2'/>">こちら</a></li>
	</ul>
</body>
</html>