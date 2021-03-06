package net.bitacademy.java67.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.dao.LectureDao;
import net.bitacademy.java67.domain.LectureVo;


@WebServlet("/lecture/change")
public class LectureChangeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void doPost(
      HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    
    LectureDao lectureDao = 
        (LectureDao) this.getServletContext().getAttribute("lectureDao");
    
    LectureVo lecture = new LectureVo();
    lecture.setLno(Integer.parseInt(request.getParameter("lno")));
    lecture.setTitle(request.getParameter("title"));
    lecture.setSt_date(Date.valueOf(request.getParameter("st_date")));
    lecture.setEd_date(Date.valueOf(request.getParameter("ed_date")));
    lecture.setHours(Integer.parseInt(request.getParameter("hours")));
    lecture.setDays(Integer.parseInt(request.getParameter("days")));
    lecture.setCapa(Integer.parseInt(request.getParameter("capa")));
    lecture.setIntro(request.getParameter("intro"));
    lecture.setMno(Integer.parseInt(request.getParameter("mno")));
    lecture.setCno(Integer.parseInt(request.getParameter("cno")));
    
    lectureDao.update(lecture);
    
    response.sendRedirect("list");
    
  }
  
}













