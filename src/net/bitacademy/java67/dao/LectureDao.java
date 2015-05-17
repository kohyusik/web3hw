package net.bitacademy.java67.dao;

import java.util.List;

import net.bitacademy.java67.DaoException;
import net.bitacademy.java67.domain.ClassroomVo;
import net.bitacademy.java67.domain.LectureVo;
import net.bitacademy.java67.domain.ManagerVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/* 실습 내용: mybatis 사용 */

public class LectureDao {
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public void insert(final LectureVo lecture) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.insert("net.bitacademy.java67.dao.LectureDao.insert", lecture);
      sqlSession.commit();
      
    } catch (Exception e) {
      throw new DaoException(e);

    } finally {
      sqlSession.close();
    }
  }
  
  public List<LectureVo> selectList() {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      return sqlSession.selectList(
          "net.bitacademy.java67.dao.LectureDao.selectList");

    } catch (Exception e) {
      throw new DaoException(e);

    } finally {
      sqlSession.close();
    }

  }
  
  public LectureVo selectOne(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      return sqlSession.selectOne(
          "net.bitacademy.java67.dao.LectureDao.selectOne", no);
      
    } catch (Exception e) {
      throw new DaoException(e);

    } finally {
      sqlSession.close();
    }
  }

  
  public int delete(int no) {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      int count = sqlSession.delete(
          "net.bitacademy.java67.dao.LectureDao.delete", no);
      sqlSession.commit();
      return count;
      
    } catch (Exception e) {
      throw new DaoException(e);

    } finally {
      sqlSession.close();
    }
  }
  
  public int update(LectureVo lecture) {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      int count = sqlSession.update(
          "net.bitacademy.java67.dao.LectureDao.update", lecture);
      sqlSession.commit();
      return count;
      
    } catch (Exception e) {
      throw new DaoException(e);

    } finally {
      sqlSession.close();
    }
    
  }

public List<ManagerVo> selectManagerList(int no) {
	// TODO Auto-generated method stub
	return null;
}

public List<ClassroomVo> selectClassroomList(int no) {
	// TODO Auto-generated method stub
	return null;
}
  

}











