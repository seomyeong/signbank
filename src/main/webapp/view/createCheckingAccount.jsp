<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignBank</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/createCheckingAccount.css">
</head>
<body>
	<jsp:include page="../incl/header.jsp"></jsp:include>

	<main>
		<h1>계좌개설</h1>
		<form action="createCheckingAccount.do" method="post">
			<div id="savingsWrap2">
				<div id="savingsWrapTxt">
					<h2>signbank OK 마이너스 통장</h2>
					<p>${sessionScope.customerName}님의<br>
						<span>OK 마이너스 통장</span>을 개설합니다.
					</p>
					<p>현재 마이너스 한도 500만원</p>
				</div>
				<div id="savingsWrapDiv">
					<div>방문없이 가입 가능</div>
					<div>누구나 가입 가능</div>
				</div>

				<div id="initBalance">
					<p>초기 입금액</p>
					<input type="text" name="balance" id="balance"
						placeholder="초기 입금액을 입력하세요." required="required" /> <input
						type="submit" value="개설" id="savingsSubmit">
				</div>

				<div id="goInto">
					<a href="userServiceMenu.jsp" id="prev">이전</a>
				</div>
			</div>
		</form>
	</main>
</body>
</html>