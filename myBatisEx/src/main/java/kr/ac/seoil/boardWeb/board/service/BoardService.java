package kr.ac.seoil.boardWeb.board.service;

import java.util.List;

import kr.ac.seoil.boardWeb.board.vo.BoardVO;

public interface BoardService {
	//�۵��
	void createBoard(BoardVO vo) throws Exception;
	
	//�ۼ���
	void modifyBoard(BoardVO vo) throws Exception;
	
	//�ۻ���
	void removeBoard(BoardVO vo) throws Exception;
	
	//�ۻ�
	BoardVO getBoard(BoardVO vo) throws Exception;
	
	//�۸��
	List<BoardVO> getBoardList(BoardVO vo) throws Exception;
}
