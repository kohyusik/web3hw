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
<h2>강의 등록</h2>
<input type='button' value='목록으로' onclick='location.href="list";'>
<form action="add" method="post">
강의명: <input type='text' name='title' required><br>           
시작일: <input type='date' name='st_date' required><br>         
종료일: <input type='date' name='ed_date' required><br>         
총 강의시간(시간): <input type='number' name='hours' required><br>  
총 강의일수(일): <input type='number' name='days' required><br>    
총 인원(명): <input type='number' name='capa' required><br>    
매니져: <select name='mno'><option value='0'>미배정</option>
        <c:forEach items="${requestScope.managerList}" var="manager">
          <option value='${manager.no}'>${manager.name}</option>
        </c:forEach>
      </select><br>    
강의실: <select name='cno'><option value='0'>미배정</option>
        <c:forEach items="${classroomList}" var="classroom">
          <option value='${classroom.CNO}'>${classroom.LOC} - ${classroom.ROOM}</option>
        </c:forEach>
      </select><br>
인트로:<br> <textarea cols='75' rows='10' name='intro'></textarea><br>
<input type='submit' value='등록'>
<input type='button' value='취소' onclick="location.href='list';">
</form>
<jsp:include page="/Footer.jsp"/>
</body>
</html>