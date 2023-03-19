package kr.ac.seoil.boardWeb.board.service;

import java.util.List;

import kr.ac.seoil.boardWeb.board.vo.BoardVO;

public interface BoardService {
	//글등록
	void createBoard(BoardVO vo) throws Exception;
	
	//글수정
	void modifyBoard(BoardVO vo) throws Exception;
	
	//글삭제
	void removeBoard(BoardVO vo) throws Exception;
	
	//글상세
	BoardVO getBoard(BoardVO vo) throws Exception;
	
	//글목록
	List<BoardVO> getBoardList(BoardVO vo) throws Exception;
}
