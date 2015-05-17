package net.bitacademy.java67.dao;

import java.util.List;

import net.bitacademy.java67.DaoException;
import net.bitacademy.java67.domain.ManagerVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class ManagerDao {
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }


  public List<ManagerVo> selectList() {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      return sqlSession.selectList(
          "net.bitacademy.java67.dao.ManagerDao.selectList");

    } catch (Exception e) {
      throw new DaoException(e);

    } finally {
      sqlSession.close();
    }

  }
  
  
}