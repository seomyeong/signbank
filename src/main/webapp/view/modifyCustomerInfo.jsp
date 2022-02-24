<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignBank</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/modifyCustomerInfo.css">
</head>
<body>
	<jsp:include page="../incl/header.jsp"></jsp:include>
	<div id="modifyWrap">
		<h2>회원정보 수정</h2>
		<form action="modifyCustomerInfo2.do" method="post">
			<table>
						<caption>수정하실 정보를 입력해주세요.</caption>
						<tr>
							<th>ID</th>
							<td><input type="text" value="${customer.userId}" id="first"
								name="userId" readonly></td>
						</tr>
						<tr>
							<th><span class="asterisk">*</span> PW</th>
							<td><input type="password" value="${customer.userPw}"
								name="userPw"></td>
						</tr>
						<tr>
							<th><span class="asterisk">*</span> 이름</th>
							<td><input type="text" value="${customer.name}" name="name"></td>
						</tr>
			</table>
			<div id="modifyBtn">
				<a href="userServiceMenu.jsp" id="prev">이전</a> <input type="submit"
					value="수정">
			</div>
		</form>
	</div>
</body>
</html>