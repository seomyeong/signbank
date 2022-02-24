<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignBank</title>
<link href='<c:url value="/css/accountInquiryService.css"/>'
	rel="stylesheet" type="text/css" />
</head>

<body>
	<jsp:include page="../incl/header.jsp"></jsp:include>
	<div id="main">
		<div id="accountInfoWrap">
			<h1>계좌조회</h1>
			<p>${sessionScope.customerName}님의 계좌조회 결과입니다.</p>

			<div id="accountInfo">
				<table>
					<thead>
						<tr id="accountInfoList">
							<td>계좌번호</td>
							<td>계좌타입</td>
							<td>잔액</td>
							<td>한도</td>
							<td>계좌개설일</td>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty accountList}">
							<c:forEach var="account" items="${accountList}">
								<tr>
									<td>${account.accountNum}</td>
									<td>${account.accType}</td>
									<td><fmt:formatNumber value="${account.balance}"
											type="currency" />원</td>
									<td><fmt:formatNumber value="${account.overdraftAmount}"
											type="currency" />원</td>
									<td>${account.regDate}</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>

		</div>
		<a href="userServiceMenu.jsp">메인메뉴로 이동</a>
	</div>
</body>
</html>