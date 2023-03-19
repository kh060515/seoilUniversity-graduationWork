package kr.ac.seoil.boardWeb.board.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.ac.seoil.boardWeb.board.service.BoardService;
import kr.ac.seoil.boardWeb.board.vo.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) throws Exception {
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext container =
			new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로 부터 BoardServiceImpl 객체를 Lookup 한다.
		BoardService boardService = (BoardService) container.getBean("boardService");
	
//		BoardVO vo = new BoardVO();
//		vo.setSeq(1000);
//		BoardVO ret = boardService.getBoard(vo);
//		if (ret == null) {
//			System.out.println(vo.getSeq() + "게시물 없음");
//		} else {
//			System.out.println(vo.toString());
//		}
		
		// 3. 글 등록 테스트
		BoardVO vo = new BoardVO();
		vo.setTitle("임시제목");
		vo.setWriterName("최석원");
		vo.setContent("임시내용...........");
		boardService.createBoard(vo);
		
		// 4. 글 목록 테스트
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("--->" + board.toString());
		}
		
		// 5. Spring 컨테이너 종료
		container.close();
	}

}








