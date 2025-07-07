<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOP</title>
</head>
<body>
	<h3>HTTPセッションの利用</h3>
	<ul>
		<li>セッション属性（@SessionAttributes）の利用： types属性でフォームまるごと管理　<a href="<c:url value='/type01/first'/>">こちら</a></li>
	</ul>
	<ul>
		<li>セッション属性（@SessionAttributes）の利用： types属性でフォームまるごと管理　セッション確認：　<a href="<c:url value='/test/'/>">こちら</a></li>
	</ul>
	<ul>
		<li>セッション属性（@SessionAttributes）の利用： names属性で複数フォームを管理　<a href="<c:url value='/type02/first'/>">こちら</a></li>
	</ul>
	<ul>
		<li>セッションスコープの利用：　<a href="<c:url value='/type03/items/'/>">こちら</a></li>
	</ul>
</body>
</html>