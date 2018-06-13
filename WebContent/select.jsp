<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<!--  セッションの内容がnullのとき、インデックスページに飛ばす  -->
<c:if test="${empty sessionScope.Name}">
	<c:redirect url="index.jsp"/>
</c:if>
<p>検索したいデータ情報を入力してください<br>
※全て空白の場合は全検索を行います</p>


<form action="select">
  <fieldset>
    <div>
      <label>ID</label><input type="text" name="id"value="${fn:escapeXml(param.id)}">
    </div>
    <div>
      <label>名前</label><input type="text" name="name"value="${fn:escapeXml(param.name)}">
    </div>
    <div>
      <label>TEL</label><input type="text" name="tel"value="${fn:escapeXml(param.tel)}">
    </div>
  </fieldset>
  <input type="submit" value="検索">
</form>
<div>
 <c:if test="${not empty msg}">
    <p class ="error">${msg}</p>
  </c:if>
  <a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>
