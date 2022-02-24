<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignBank</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/successModifyCustomerInfo.css">
</head>

</head>
<body>
	<jsp:include page="../incl/header.jsp"></jsp:include>
	<div id="main">
		<div id="accountInfoWrap">
			<h1>정보수정 완료</h1>
			<h2>
				고객님의 회원정보가 정상적으로 변경되었습니다.<br> 감사합니다.
			</h2>

			<div id="accountInfo">
				<form action="userServiceMenu.do" method="POST">
					<input type="submit" value="메인메뉴로 이동" id="home">
				</form>
			</div>

		</div>
	</div>
</body>
</html>