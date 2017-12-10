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
② 이수 구분별 학점 조회
</h3>


  <P>① 학기별 이수 학점 조회  <a href="${pageContext.request.contextPath}/offers">Go</a></P>
<P>② 수강 신청하기  <a href="${pageContext.request.contextPath}/login">Go</a></P>
<P>③ 수강 신청 조회  <a href="${pageContext.request.contextPath}/login">Go  </a></P>


<table class="w3-table w3-striped">
 <tr>
      <th>교필</th>
      <th>토대</th>
      <th>인재</th>
      <th>핵교A</th>
      <th>핵교B</th>
      <th>전지</th>
      <th>전선</th>
      <th>전기</th>
      <th>일교</th>
      <th>인재</th>
      <th>자율</th>
      <th>총학점</th>
    </tr>
    <tr>
      <td><c:out value="${division.getA()}"></c:out></td>
      <td><c:out value="${division.getB()}"></c:out></td>
      <td><c:out value="${division.getC()}"></c:out></td>
      <td><c:out value="${division.getD()}"></c:out></td>
      <td><c:out value="${division.getE()}"></c:out></td>
      <td><c:out value="${division.getF()}"></c:out></td>
      <td><c:out value="${division.getG()}"></c:out></td>
      <td><c:out value="${division.getH()}"></c:out></td>
      <td><c:out value="${division.getI()}"></c:out></td>
      <td><c:out value="${division.getJ()}"></c:out></td>
      <td><c:out value="${division.getK()}"></c:out></td>
       <td><c:out value="${division.getSum()}"></c:out></td>
    </tr>


  </table>
</body>
</html>