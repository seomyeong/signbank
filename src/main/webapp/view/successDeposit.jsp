<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignBank</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/successDeposit_withDraw.css">
</head>
<body>
	<jsp:include page="../incl/header.jsp"></jsp:include>
	<h2>입금 성공!</h2>
	<div id="successDepositIMG"></div>
	<div id="successDepositWrap">
		<p>
			<span>${accountNum}</span> 계좌로<br> <span><fmt:formatNumber
					value="${balance}" type="currency" /></span>원을<br> 입금하였습니다.
		</p>
		<form action="userServiceMenu.do" method="POST">
			<input id="home" type="submit" value="메인메뉴로 이동">
		</form>
	</div>
</body>
</html>