<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignBank</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/deleteCustomer.css">
</head>
<body>
	<%@include file="/incl/header.jsp"%>
    <h2>회원 탈퇴</h2>
	<div id="modifyWrap">
		<form action="deleteCustomer2.do" method="post">
						<div id="info">
						<table>
						<caption>본인 확인을 위해 비밀번호를 입력해주세요.</caption>
							<tr>
								<th>ID</th>
								<td><input type="text" value="${customer.userId}"
									id="first" name="userId" class="input" readonly></td>
							</tr>
							<tr>
								<th><span class="asterisk">*</span> PW</th>
								<td><input type="password" class="input" name="userPw"
									placeholder="비밀번호를 입력해주세요." required="required"></td>
							</tr>
						</table>
					</div>
            <div id="modifyBtn">
                <a href="userServiceMenu.jsp" id="prev">이전</a>
                <input type="submit" value="회원 탈퇴">
            </div>    
        </form>
	</div>
</body>
</html>