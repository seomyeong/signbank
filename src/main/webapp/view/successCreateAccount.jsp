<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignBank</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/successCreateAccount.css">

</head>
<body>
	<jsp:include page="../incl/header.jsp"></jsp:include>

	<h2>계좌 개설 성공!</h2>
	<div id="successAccountIMG"></div>
	<div id="savingsWrap">
		<p>
			축하드립니다.<br> <span>${sessionScope.customerName}</span>님의<br>계좌
			개설이 성공적으로 완료되었습니다.
		</p>
		<form action="userServiceMenu.do" method="post">
			<input type="submit" id="home" value="메인메뉴로 이동">
		</form>
	</div>
</body>
</html>