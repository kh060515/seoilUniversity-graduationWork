package kr.ac.seoil.boardWeb.board.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.seoil.boardWeb.board.vo.BoardVO;

@Repository("boardDAO")	//이름 설정 안하면 class명인 BoardDAOmybatis로 설정된다.
public class BoardDAOmybatis /*extends SqlSessionDaoSupport*/{
	/*
	 * @Autowired public void setSqlSessionFactory(SqlSessionFactory
	 * sqlSessionFactory) { super.setSqlSessionFactory(sqlSessionFactory); }
	 */
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard",vo);//"BoardDAO.insertBoard"<-mybatis파일을 만들 때 인식할 파일이름.board-mapping.xml에다가 설정한다.
	}
	
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard",vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteBoard",vo);
	}
	
	public BoardVO selectBoard(BoardVO vo) {
		return mybatis.selectOne("BoardDAO.selectBoard", vo);
	}
	
	public List<BoardVO> selectBoardList(BoardVO vo){
		return mybatis.selectList("BoardDAO.selectBoardList", vo);
	}
}


