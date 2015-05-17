package net.bitacademy.java67.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.dao.LectureDao;

/* 실습 목표: 게시물 삭제하기
 * 
 */

@WebServlet("/lecture/delete")
public class LectureDeleteServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    LectureDao lectureDao = 
        (LectureDao) this.getServletContext().getAttribute("lectureDao");
    
    lectureDao.delete(Integer.parseInt(request.getParameter("no")));
    
    response.sendRedirect("list");
  }
}













