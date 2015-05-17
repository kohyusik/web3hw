package net.bitacademy.java67.listener;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import net.bitacademy.java67.dao.ClassroomDao;
import net.bitacademy.java67.dao.LectureDao;
import net.bitacademy.java67.dao.ManagerDao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ContextLoaderListener implements ServletContextListener {
  DataSource dataSource;
  
  @Override
  public void contextInitialized(ServletContextEvent event) {
    // 웹 애플리케이션을 실행하는 동안 사용할 기본 객체 준비.
    ServletContext ctx = event.getServletContext();
    System.out.println("ctx준비..");

    try {
      //mybatis 객체 준비
      // - FileInputStream을 사용하면 안되는가?
      //   답변: 
      // 1. FileInputStream을 사용하는 경우,
      // 1) 현재 웹 애플리케이션의 경로를 알아낸다.
      InputStream mybatisConfigInputStream = Resources.getResourceAsStream(
          "net/bitacademy/java67/dao/mybatis-config.xml");
      
      // SqlSessionFactoryBuilder는 mybatis 설정 파일을 읽는다.
      // - 설정 파일의 내용에 따라 동작하는 SqlSessionFactory를 생성한다.
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(mybatisConfigInputStream);

      
      LectureDao lectureDao = new LectureDao();
      ManagerDao managerDao = new ManagerDao();
      ClassroomDao classroomDao = new ClassroomDao();
      
      lectureDao.setSqlSessionFactory(sqlSessionFactory);
      managerDao.setSqlSessionFactory(sqlSessionFactory);
      classroomDao.setSqlSessionFactory(sqlSessionFactory);

      ctx.setAttribute("lectureDao", lectureDao);
      ctx.setAttribute("managerDao", managerDao);
      ctx.setAttribute("classroomDao", classroomDao);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {}


}







