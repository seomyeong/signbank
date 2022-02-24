<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignBank</title>
<link href='<c:url value="/css/deposit_withDraw.css"/>' rel="stylesheet"
	type="text/css" />
</head>
<body>
	<jsp:include page="../incl/header.jsp"></jsp:include>
	<div id="main">
		<form action="deposit2.do" method="POST">
			<div id="accountInfoWrap">
				<h1>입금</h1>
				<p>입금하실 계좌를 선택하세요.</p>
				<div id="accountInfo">
					<table>
						<thead>
							<tr id="accountInfoList">
								<td>계좌번호</td>
								<td>계좌타입</td>
								<td>잔액</td>
								<td>계좌개설일</td>
								<td>계좌선택</td>
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
										<td>${account.regDate}</td>
										<td><input type="radio" name="accountNum"
											value="${account.accountNum}"></td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
			<div id="depositWrap">
				<p>입금액</p>
				<input type="text" name="amount" id="deposit" value=""
					placeholder="입금액을 입력하세요." required="required"> <input
					type="submit" value="확인" id="depositSubmit">
			</div>
			<div id="goInto">
				<a href="userServiceMenu.jsp">메인메뉴로 이동</a>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		const input = document.getElementsByTagName('input');
		const inputFirst = input[0].setAttribute('checked', 'checked')
	</script>
</body>
</html>