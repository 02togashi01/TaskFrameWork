<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<!--  セッションの内容がnullのとき、インデックスページに飛ばす  -->
<c:if test="${empty sessionScope.Name}">
	<c:redirect url="index.jsp"/>
</c:if>
<p>更新を行うデータのIDを入力してください<br>
<span class="required"></span>は必須です</p>


<form action="update" method="post">
  <fieldset>
    <div>
      <label class="required">ID</label><input type="text" name="id">
    </div>
  </fieldset>

  <!--  エラーメッセージ  -->
  <c:if test="${not empty msg}">
    <p class ="error">${msg}</p>
  </c:if>

  <input type="submit" value="確認">
</form>
<div>
  <a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>
