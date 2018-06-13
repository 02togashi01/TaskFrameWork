<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容確認画面</title>
<link href="css/commons.css" rel="stylesheet">
<style>
.col {
  float: left;
}

.col-clear {
  clear: both;
}

#arrow {
  margin-top: 60px;
}
</style>
</head>
<body>
<!--  セッションの内容がnullのとき、インデックスページに飛ばす  -->
<c:if test="${empty sessionScope.Name}">
	<c:redirect url="index.jsp"/>
</c:if>
<p>これでよろしいですか？</p>

<form action="updateConfirm" method="post">

  <fieldset>
   <c:forEach var="Userinfo" items="${UserinfoList}">
    <div>
      <label>ID</label><input type="text" name="id" value="${fn:escapeXml(Userinfo.usersId)}" readonly>
    </div>
     </c:forEach>
  </fieldset>

  <fieldset class="col">
    <c:forEach var="Userinfo" items="${UserinfoList}">
    <legend>変更前</legend>
    <div>
      <label>名前</label><input type="text" value = "${fn:escapeXml(Userinfo.usersName)}" disabled>
    </div>
    <div>
      <label>TEL</label><input type="text" value = "${fn:escapeXml(Userinfo.telephone)}" disabled>
    </div>
    <div>
      <label>PASS</label><input type="password" name ="password" value = "${fn:escapeXml(Userinfo.password)}" disabled>
    </div>
      </c:forEach>
  </fieldset>

  <div id="arrow" class="col">⇒</div>

  <fieldset class="col label-110">

    <legend>変更後</legend>
    <div>
      <label>名前</label><input type="text" name="newName" value="${fn:escapeXml(update.usersName)}" readonly>
    </div>
    <div>
      <label>TEL</label><input type="text" name="newTel" value="${fn:escapeXml(update.telephone)}" readonly>
    </div>
    <div>
      <label>PASS(再入力)</label><input type="password" name="rePass">
    </div>

  </fieldset>


  <div class="col-clear">
 <c:if test="${not empty msg}">
    <p class ="error">${msg}</p>
  </c:if>
    <input type="submit" name="button" value="更新">
    <input type="submit" name="button" value="戻る" onclick="location.href='updateInput.jsp'; return false;">
  </div>
</form>
<div>
  <a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>
