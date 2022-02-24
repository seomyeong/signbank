<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지</title>
<link href='<c:url value="/css/errorMsg.css"/>' rel="stylesheet" type="text/css"/>
</head>
<body>
 <div id="errorWrap">
      <h1>ERROR</h1>
          <ul>
              <c:if test="${not empty errorMsgs }">
                   <c:forEach var="eMsg" items="${errorMsgs}">
                        <li class="red">${eMsg}</li>
                   </c:forEach>
              </c:if>
          </ul>
</div>
<a id="home" onclick="javascript:history.back()">이전</a>
</body>
</html>