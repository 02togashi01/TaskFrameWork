<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<!--  セッションの内容がnullのとき、インデックスページに飛ばす  -->
<c:if test="${empty sessionScope.Name}">
	<c:redirect url="index.jsp"/>
</c:if>
<p>これでよろしいですか？</p>

<form action="insertConfirm" method="post">
  <fieldset class="label-110">
    <div>
      <label>名前</label><input type="text" name="name"  value="${tourokuname}" readonly>
    </div>
    <div>
      <label>TEL</label><input type="text" name="tel" value="${tourokutel}" readonly>
    </div>
    <div>
      <label>PASS（再入力）</label><input type="password" name="rePass">
    </div>
  </fieldset>
  <div>
    <input type="submit" name="button" value="登録">
    <input type="submit" name="button" value="戻る" onclick="location.href='insert.jsp'; return false;">
  </div>
</form>

<c:if test="${not empty msg}">
    <p class ="error">${msg}</p>
  </c:if>
<div>
  <a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>
