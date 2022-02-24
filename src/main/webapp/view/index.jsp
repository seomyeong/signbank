<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignBank</title>

<link href='<c:url value="/css/index.css"/>' rel="stylesheet"
	type="text/css" />

</head>
<body>
	<div id="bodyWrap">
		<form action="login.do" method="post" id="form">
			<h1>SIGN BANKING</h1>
			<div id="inputWrap">

				<input value="${cookie.saveId.value}" type="text" name="userId"
					id="id" maxlength="20" placeholder="아이디,이메일,전화번호"> <input
					type="password" autocomplete="off" name="userPw" id="pw"
					maxlength="12" placeholder="비밀번호" required>

				<c:choose>
					<c:when test="${cookie.saveId.value==null}">
						<label><input type="checkbox" name="saveId"><span>로그인
								상태 유지</span></label>
					</c:when>
					<c:otherwise>
						<label><input type="checkbox" name="saveId"
							checked="checked"><span>로그인 상태 유지</span></label>
					</c:otherwise>
				</c:choose>

			</div>
			<div id="submitWrap">
				<input type="submit" value="로그인" /> <a href="addCustomer.jsp">회원가입</a>
			</div>
		</form>
	</div>

</body>
</html>