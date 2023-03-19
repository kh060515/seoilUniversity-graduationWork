package kr.ac.seoil.boardWeb.board.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.ac.seoil.boardWeb.board.service.BoardService;
import kr.ac.seoil.boardWeb.board.vo.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) throws Exception {
		// 1. Spring �����̳ʸ� �����Ѵ�.
		AbstractApplicationContext container =
			new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �����̳ʷ� ���� BoardServiceImpl ��ü�� Lookup �Ѵ�.
		BoardService boardService = (BoardService) container.getBean("boardService");
	
//		BoardVO vo = new BoardVO();
//		vo.setSeq(1000);
//		BoardVO ret = boardService.getBoard(vo);
//		if (ret == null) {
//			System.out.println(vo.getSeq() + "�Խù� ����");
//		} else {
//			System.out.println(vo.toString());
//		}
		
		// 3. �� ��� �׽�Ʈ
		BoardVO vo = new BoardVO();
		vo.setTitle("�ӽ�����");
		vo.setWriterName("�ּ���");
		vo.setContent("�ӽó���...........");
		boardService.createBoard(vo);
		
		// 4. �� ��� �׽�Ʈ
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("--->" + board.toString());
		}
		
		// 5. Spring �����̳� ����
		container.close();
	}

}








