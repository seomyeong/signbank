<%@page import="signBanking.service.CustomerService"%>
<%@page import="java.util.HashMap"%>
<%@page import="signBanking.service.AccountService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignBank</title>
<link href='<c:url value="/css/userServiceMenu.css"/>' rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<c:url value="/WEB-INF/lib/jquery-3.6.0.js"/>"></script>
</head>
<body>

	<jsp:include page="../incl/header.jsp"></jsp:include>
	<div id="form">
		<div id="main">
			<div id="mainWrap">

				<div id="userInfo">
					<p>${sessionScope.customerName}님,<br> SIGN BANK에<br>
						오신것을 환영합니다.
					</p>

					<form action="accountInquiryService.do" method="POST">
						<input type="submit" value="계좌조회" />
					</form>

					<form action="modifyCustomerInfo.do" method="POST">
						<input type="submit" value="회원정보 수정" />
					</form>

					<form action="logout.do" method="POST">
						<input type="submit" value="로그아웃" class="logout" />
					</form>

					<form action="deleteCustomer.do" method="POST">
						<input type="submit" value="회원탈퇴" />
					</form>
				</div>
				<div id="acct">
					<div id="countAcct">
						<p>${show["customerName"]}고객님의 총 자산</p>
						<div id="totalBalance">
							<fmt:formatNumber value="${sessionScope.totalBalance}"
								type="currency" />
							원
						</div>
					</div>

					<div id="menu">
						<ul id="balance">
							<li>
								<form action="deposit.do" method="post">
									<input type="submit" value="입금" />
								</form>
							</li>
							<li>
								<form action="withDraw.do" method="post">
									<input type="submit" value="출금" />
								</form>
							</li>
						</ul>
						<ul id="acctype">
							<li><a href="createSavingsAccount.jsp">일반 통장</a></li>
							<li><a href="createCheckingAccount.jsp">마이너스 통장</a></li>
						</ul>
					</div>
				</div>

			</div>
		</div>

	</div>
	<script>
		
	</script>

</body>
</html>