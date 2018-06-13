<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<!--  セッションの内容がnullのとき、インデックスページに飛ばす  -->
<c:if test="${empty sessionScope.Name}">
	<c:redirect url="index.jsp"/>
</c:if>

    <table border="1">
    <caption>検索結果</caption>

    <tr>
      <th>usersid</th>
      <th>userName</th>
      <th>telephone</th>
    </tr>
    <c:forEach var="Userinfo" items="${UserinfoList}">
      <tr>
        <td>${fn:escapeXml(Userinfo.usersId)}</td>
        <td>${fn:escapeXml(Userinfo.usersName)}</td>
        <td>${fn:escapeXml(Userinfo.telephone)}</td>
      </tr>
    </c:forEach>
  </table>



<div>
  <a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>
