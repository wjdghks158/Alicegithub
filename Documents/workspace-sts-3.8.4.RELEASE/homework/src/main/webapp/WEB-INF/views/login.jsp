<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css" />

</head>
<body>
	<P>로그인 하시고 이용하세요	</P>
	<div>
		<form name="question" method="post"
			action="<c:url value="/login"/>">
			<div>
			<c:if test="${not empty errorMsg}">
			<div style="color:#ff0000"> <h3> "${errorMsg}" </h3></div>
			</c:if>
				<label for="userId">사용자 아이디</label> <input type="text"
					name="username" placeholder="User ID">
			</div>
			<div >
				<label for="password">비밀번호</label> <input type="password"
					name="password" placeholder="Password"> 
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

			</div>
			<button type="submit">로그인</button>

		</form>
	</div>

</body>
</html>