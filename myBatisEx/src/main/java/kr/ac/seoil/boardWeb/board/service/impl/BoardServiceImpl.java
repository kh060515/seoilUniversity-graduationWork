package kr.ac.seoil.boardWeb.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.ac.seoil.boardWeb.board.service.BoardService;
import kr.ac.seoil.boardWeb.board.vo.BoardVO;
import kr.ac.seoil.boardWeb.common.LogAdvice;

@Service("boardService")//만약 service를 따로 지정 안해주면 class명이 된다 ex)BoardServiceImpl로 됨
public class BoardServiceImpl implements BoardService {
	//@Autowired
	//private BoardDAO boardDAO;
	
	@Resource(name="boardDAO")
	private BoardDAOmybatis boardDAO;
	
	@Override
	public void createBoard(BoardVO vo) throws Exception {
		boardDAO.insertBoard(vo);
	}
	
	@Override
	public void modifyBoard(BoardVO vo) throws Exception {
		boardDAO.updateBoard(vo);
	}
	
	@Override
	public void removeBoard(BoardVO vo) throws Exception {
		boardDAO.deleteBoard(vo);
	}
	
	@Override
	public BoardVO getBoard(BoardVO vo) throws Exception {
		return boardDAO.selectBoard(vo);
	}
	
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) throws Exception {
		return boardDAO.selectBoardList(vo);
	}
}












