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
<h2>강의 상세정보</h2>
<input type='button' value='목록으로' onclick='location.href="list";'>
<form action="change?no=${lecture.lno}" method="post">
번호: <input type='text' name='lno' readonly value='${lecture.lno}'><br>
강의명: <input type='text' name='title' value='${lecture.title}' required><br>           
시작일: <input type='date' name='st_date' value='${lecture.st_date}' required><br>         
종료일: <input type='date' name='ed_date' value='${lecture.ed_date}' required><br>         
총 강의시간(시간): <input type='number' name='hours' value='${lecture.hours}' required><br>  
총 강의일수(일): <input type='number' name='days' value='${lecture.days}' required><br>    
총 인원(명): <input type='number' name='capa' value='${lecture.capa}' required><br>
매니져: <select name='mno'><option value='0'>미배정</option>
				<c:forEach items="${requestScope.managerList}" var="manager">
				<c:set var="mmno" value="${manager.no}"/>
				<c:set var="lmno" value="${lecture.mno}"/>
					<c:choose>
						<c:when test="${mmno == lmno}">
						  <option value='${manager.no}' selected>${manager.name}</option>
						</c:when>
						<c:otherwise>
						  <option value='${manager.no}'>${manager.name}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select><br> 
강의실: <select name='cno'><option value='0'>미배정</option>
        <c:forEach items="${requestScope.classroomList}" var="classroom">
        <c:set var="ccno" value="${classroom.CNO}"/>
        <c:set var="lcno" value="${lecture.cno}"/>
          <c:choose>
            <c:when test="${ccno == lcno}">
              <option value='${classroom.CNO}' selected>${classroom.LOC} - ${classroom.ROOM}</option>
            </c:when>
            <c:otherwise>
              <option value='${classroom.CNO}'>${classroom.LOC} - ${classroom.ROOM}</option>
            </c:otherwise>
          </c:choose>
        </c:forEach>
      </select><br>
인트로:<br> <textarea cols='75' rows='10' name='intro'>${lecture.intro}</textarea><br>
<input type='submit' value='변경'>
<input type='button' value='삭제' onclick='location.href="delete?no=${lecture.lno}";'/>
<input type='button' value='취소' onclick="location.href='list';">
</form>
<jsp:include page="/Footer.jsp"/>
</body>
</html>