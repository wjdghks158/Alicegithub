<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<title>Insert title here</title>
</head>
<body>

<h3>
① 학년/학기별 이수 총 학점
</h3>

<table class="w3-table w3-striped">
 <tr>
      <th>년도</th>
      <th>학기</th>
      <th>이수 학점</th>
      <th>상세보기</th>
    </tr>
  
  
  
  <P>① 학기별 이수 학점 조회  <a href="${pageContext.request.contextPath}/offers">Show current offers</a>
<P>② 이수 구분별 학점 조회  <a href="${pageContext.request.contextPath}/apply">Show current offers</a>
<P>③ 수강 신청하기  <a href="${pageContext.request.contextPath}/login">Show current login</a>
<P>④ 수강 신청 조회  <a href="${pageContext.request.contextPath}/login">Show current login</a>



<c:forEach var="semesterInfo" items="${semesters}"> 
    <tr>
      <td><c:out value="${semesterInfo.getYear()}"></c:out></td>
      <td><c:out value="${semesterInfo.getSemester()}"></c:out></td>
      <td><c:out value="${semesterInfo.getGrades()}"></c:out></td>
      <td><P>  <a href="${pageContext.request.contextPath}/history?year=${semesterInfo.getYear()}&semester=${semesterInfo.getSemester()}">링크</a></td>
    </tr>

<p>
<c:out value="${lecture}"></c:out>
</p>
</c:forEach>
  </table>
</body>
</html>