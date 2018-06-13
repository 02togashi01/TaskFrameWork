<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容入力画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<!--  エラーメッセージ  -->
 <c:if test="${not empty msg}">
    <p class ="error">${msg}</p>
  </c:if>
<!--  セッションの内容がnullのとき、インデックスページに飛ばす  -->
<c:if test="${empty sessionScope.Name}">
	<c:redirect url="index.jsp"/>
</c:if>
<p>１箇所以上の項目を変更してください<br>
※IDは変更できません</p>

<form action="updateInput" method="post">
  <c:forEach var="Userinfo" items="${UserinfoList}">
  <fieldset>

    <div>

      <label>ID</label><input type="text" name="id" value="${fn:escapeXml(Userinfo.usersId)}" readonly>

    </div>
    <div>
      <label>名前</label><input type="text" name="newName" value="${fn:escapeXml(Userinfo.usersName)}">
    </div>
    <div>
      <label>TEL</label><input type="text" name="newTel" value="${fn:escapeXml(Userinfo.telephone)}" >
    </div>
    <div>
      <label>PASS</label><input type="password" name="newPass" value="${fn:escapeXml(Userinfo.password)}">
    </div>

  </fieldset>
 </c:forEach>
  <div>
    <input type="submit" name="button" value="確認">
    <input type="submit" name="button" value="戻る" onclick="location.href='update.jsp'; return false;">
  </div>

</form>
<div>
  <a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>
