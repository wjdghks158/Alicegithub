<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<P>  <a href="${pageContext.request.contextPath}/apply">Show current 여긴 apply</a>

<div>
   <sf:form name="question" method="post" action="${pageContext.request.contextPath}/dologin">
              <div >
                  <label for="userId">사용자 아이디</label>
                  <input type="text"  name="userId" placeholder="User ID" />
              </div>
              <div class="form-group">
                  <label for="password">비밀번호</label>
                  <input type="password"  name="password" placeholder="Password"/>
              </div>
              <button type="submit" >로그인</button>
              
          </sf:form>   
    </div> 

</body>
</html>