package net.bitacademy.java67.dao;

import java.util.List;

import net.bitacademy.java67.DaoException;
import net.bitacademy.java67.domain.ClassroomVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ClassroomDao {
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  
  public List<ClassroomVo> selectList() {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      return sqlSession.selectList(
          "net.bitacademy.java67.dao.ClassroomDao.selectList");

    } catch (Exception e) {
      throw new DaoException(e); 

    } finally {
      sqlSession.close();
    }

  }
  

  public ClassroomVo selectOne() {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      return sqlSession.selectOne(
          "net.bitacademy.java67.dao.ClassroomDao.selectOne");

    } catch (Exception e) {
      throw new DaoException(e); 

    } finally {
      sqlSession.close();
    }
  }

}











