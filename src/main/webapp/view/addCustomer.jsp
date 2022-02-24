<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignBank</title>
<link rel="stylesheet" href="../css/addCustomer.css">
</head>
<body>
	
	<form action="addCustomer.do" method="post">
		<table>
			<caption>회원가입</caption>
			<tbody>
				<tr id="id">
					<th>아이디<span class="mustIcon">*</span>
					<c:if test="${not empty userIdState}">
							<span class="warningTxt"> ${userIdState}</span>
						</c:if></th>
					<td><c:choose>
							<c:when test="${not empty userId}">
								<input type="text" name="userId" maxlength="20" id="id"
									placeholder="아이디를 입력하세요" value="${userId}" />
							</c:when>
							<c:otherwise>
								<input type="text" name="userId" maxlength="20" id="id"
									placeholder="아이디를 입력하세요" />
							</c:otherwise>
						</c:choose></td>
				</tr>
				<tr id="pw">
					<th>비밀번호<span class="mustIcon">*</span> <c:if
							test="${not empty userPwState}">
							<span class="warningTxt"> ${userPwState}</span>
						</c:if></th>
					<td><c:choose>
							<c:when test="${not empty userPw}">
								<input type="password" name="userPw" maxlength="12" id="pw"
									placeholder="비밀번호를 입력하세요" value="${userPw}" />
							</c:when>
							<c:otherwise>
								<input type="password" name="userPw" maxlength="12" id="pw"
									placeholder="비밀번호를 입력하세요" />
							</c:otherwise>
						</c:choose></td>
				</tr>
				<tr>
					<th>이름<span class="mustIcon">*</span> <c:if
							test="${not empty nameState}">
							<span class="warningTxt"> ${nameState}</span>
						</c:if></th>
					<td><c:choose>
							<c:when test="${not empty name}">
								<input type="text" name="name" id="pw" placeholder="이름을 입력하세요"
									value="${name}" />
							</c:when>
							<c:otherwise>
								<input type="text" name="name" id="pw" placeholder="이름을 입력하세요" />
							</c:otherwise>
						</c:choose></td>
				</tr>

				<tr>
					<th>주민등록번호<span class="mustIcon">*</span> <c:if
							test="${not empty ssnState}">
							<span class="warningTxt"> ${ssnState}</span>
						</c:if></th>
					<td id="ssnCenter"><c:choose>
							<c:when test="${not empty ssn1}">
								<input type="text" name="ssn1" maxlength="6"
									placeholder="주민번호 앞 6자리" value="${ssn1}" />
							</c:when>
							<c:otherwise>
								<input type="text" name="ssn1" maxlength="6"
									placeholder="주민번호 앞 6자리" />
							</c:otherwise>
						</c:choose> - <c:choose>
							<c:when test="${not empty ssn2}">
								<input type="text" name="ssn2" maxlength="7"
									placeholder="주민번호 뒤 7자리" value="${ssn2}" />
							</c:when>
							<c:otherwise>
								<input type="text" name="ssn2" maxlength="7"
									placeholder="주민번호 뒤 7자리" />
							</c:otherwise>
						</c:choose></td>
				</tr>
			</tbody>
		</table>
		<div id="submit">
			<input type="submit" value="확인"> <a href="index.jsp">홈으로</a>
		</div>

	</form>
</body>
</html>