<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lecture</title>
  <jsp:include page="/CommonStyle.jsp"/>
</head>
<body>
  <h1>Lecture List</h1>
  <p><a href='newform'>강의 등록</a></p>
  <table border='1'>
  <tr> 
    <th>번호</th> <th>제목</th> <th>시작일</th> <th>종료일</th> <th>일 수</th> <th>총 인원</th>
  </tr>
<c:forEach items="${requestScope.list}" var="lecture">
  <tr>
    <td>${lecture.lno}</td>
    <td><a href='detail?no=${lecture.lno}'>${lecture.title}</a></td>
    <td>${lecture.st_date}</td>
    <td>${lecture.ed_date}</td>
    <td>${lecture.days}</td>
    <td>${lecture.capa}</td>
  </tr>
</c:forEach>
  </table>
  <jsp:include page="/Footer.jsp"/>
</body>
</html>
