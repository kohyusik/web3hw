package net.bitacademy.java67.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.dao.LectureDao;
import net.bitacademy.java67.domain.LectureVo;

/* 실습 목표: 제목에 상세보기 링크 걸기
 *          
 */
@WebServlet("/lecture/list")
public class LectureListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    LectureDao lectureDao = 
        (LectureDao) this.getServletContext().getAttribute("lectureDao");

    List<LectureVo> list = lectureDao.selectList();
    request.setAttribute("list", list);

    response.setContentType("text/html;charset=UTF-8");

    RequestDispatcher rd = 
        request.getRequestDispatcher("/lecture/LectureList.jsp");
    rd.include(request, response);

  }


}










