<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignBank</title>
<link href='<c:url value="/css/successAddCustomer.css"/>'
	rel="stylesheet" type="text/css" />

</head>
<body>
	<div id="errorWrap">
		<div id="hWrap">
			<h1>가입완료</h1>
			<h2>${name}님의 회원가입을 진심으로 축하드립니다!</h2>

			<h3>고객님의 정보가 맞으신가요?</h3>
			<h3>
				맞으시다면 <i>'홈으로'</i> 가서 로그인!
			</h3>
		</div>
	</div>
	<a id="home" href="index.jsp">홈으로</a>
</body>
</html>