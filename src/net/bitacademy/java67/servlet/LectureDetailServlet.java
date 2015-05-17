package net.bitacademy.java67.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.dao.ClassroomDao;
import net.bitacademy.java67.dao.LectureDao;
import net.bitacademy.java67.dao.ManagerDao;
import net.bitacademy.java67.domain.ClassroomVo;
import net.bitacademy.java67.domain.LectureVo;
import net.bitacademy.java67.domain.ManagerVo;

@WebServlet("/lecture/detail")
public class LectureDetailServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    LectureDao lectureDao = 
        (LectureDao) this.getServletContext().getAttribute("lectureDao");
    ManagerDao managerDao = 
        (ManagerDao) this.getServletContext().getAttribute("managerDao");
    ClassroomDao classroomDao = 
        (ClassroomDao) this.getServletContext().getAttribute("classroomDao");

    // 매니져 리스트 - 교실 리스트 
    LectureVo lecture = lectureDao.selectOne(Integer.parseInt(request.getParameter("no")));
    List<ManagerVo> managerList = managerDao.selectList();
    List<ClassroomVo> classroomList = classroomDao.selectList();

    request.setAttribute("lecture", lecture);
    request.setAttribute("managerList", managerList);
    request.setAttribute("classroomList", classroomList);

    
    response.setContentType("text/html;charset=UTF-8");
    
    RequestDispatcher rd = 
        request.getRequestDispatcher("/lecture/LectureDetail.jsp");
    rd.include(request, response);
  }
}













