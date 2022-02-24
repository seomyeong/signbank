<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignBank</title>
<link href='<c:url value="/css/successDeleteCustomer.css"/>'
	rel="stylesheet" type="text/css" />

</head>
<body>
	<jsp:include page="../incl/header.jsp"></jsp:include>
	<div id="deleteWrap">
		<h1>회원탈퇴 완료</h1>
		<h2>SignBank 탈퇴가 완료되었습니다.</h2>
		<p>SignBank를 이용해주셔서 감사합니다.</p>
	</div>
	<a id="home" href="index.jsp">홈으로</a>
</body>
</html>