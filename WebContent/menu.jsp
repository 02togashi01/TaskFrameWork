<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>

<body>
<!--  セッションの内容がnullのとき、インデックスページに飛ばす  -->
<c:if test="${empty sessionScope.Name}">
	<c:redirect url="index.jsp"/>
</c:if>

 <c:if test="${not empty Name}">
    <p>${Name}さん、こんにちは</p>
  </c:if>
   <c:if test="${empty Name}">
    <meta http-equiv="Refresh" content="0;URL=index.jsp">
  </c:if>

<p><a href="select.jsp">検索</a></p>
<p><a href="insert.jsp">登録</a></p>
<p><a href="update.jsp">更新</a></p>
<p><a href="delete.jsp">削除</a></p>

<form action="logout.jsp" method="post">
  <input type="submit" value="ログアウト">

</form>
</body>
</html>
