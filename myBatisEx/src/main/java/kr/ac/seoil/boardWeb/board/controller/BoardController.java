package kr.ac.seoil.boardWeb.board.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.seoil.boardWeb.board.service.BoardService;
import kr.ac.seoil.boardWeb.board.service.impl.BoardDAO;
import kr.ac.seoil.boardWeb.board.vo.BoardVO;
import kr.ac.seoil.boardWeb.user.vo.UserVO;

@Controller
@RequestMapping("/board")
@SessionAttributes("board")
public class BoardController {
	
	@Autowired//Autowired를 쓰기 위해서는 BoardServiceImpl에서 @Service를 BoardService가 선언한 변수명이 되어야한다 ex)boardService
	private BoardService boardService;
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("전체", "");
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		conditionMap.put("작성자", "WRITER");
		return conditionMap;
	}
	@RequestMapping("/getList.do")
	public String getList(HttpServletRequest request, BoardVO vo, Model model) throws Exception {
		
		UserVO user = (UserVO) request.getSession().getAttribute("user");
		
		if (user == null) {
			return "redirect:/user/login.do";
		} else {

			List<BoardVO> list = boardService.getBoardList(vo);
			
			model.addAttribute("boardList", list);
			//model.addAttribute("conditionMap", searchConditionMap());
			return "board/getList";
		}
	}
	
	@RequestMapping("/getInfo.do")
	public String getInfo(HttpServletRequest request, BoardVO vo, Model model) throws Exception {
		UserVO user = (UserVO) request.getSession().getAttribute("user");
		
		if (user == null) {
			return "redirect:/user/login.do";
		} else {
			BoardVO boardVO = boardService.getBoard(vo);
		
			model.addAttribute("board", boardVO);
			return "board/getInfo";
		}

	}
	
	@RequestMapping("/modify.do")
	public String modify(@ModelAttribute("board") BoardVO vo,HttpServletRequest request) throws Exception {
		UserVO user = (UserVO) request.getSession().getAttribute("user");
		
		if (user == null) {
			return "redirect:/user/login.do";
		} else {
			boardService.modifyBoard(vo);
			return "redirect:getList.do";
		}
	}
	
	@RequestMapping("/reg.do")
	public String reg(HttpServletRequest request, BoardVO vo) {
		UserVO user = (UserVO) request.getSession().getAttribute("user");
		
		if (user == null) {
			return "redirect:/user/login.do";
		} else {
			return "board/reg";
		}
	}
	
	@RequestMapping("/create.do")
	public String create(HttpServletRequest request, BoardVO vo) throws Exception {
		UserVO user = (UserVO) request.getSession().getAttribute("user");
		
		if (user == null) {
			return "redirect:/user/login.do";
		} else {
			MultipartFile attach=vo.getAttach();
			if (!attach.isEmpty()) {
				String fileName=attach.getOriginalFilename();
				attach.transferTo(new File("D:\\202223310김경훈\\filefolder"+fileName));//첨부된 파일이 저장될 장소 지정
			}
			boardService.createBoard(vo);
			return "redirect:getList.do";
		}

	}
	
	@RequestMapping("/remove.do")
	public String remove(HttpServletRequest request, BoardVO vo) throws Exception {
		UserVO user = (UserVO) request.getSession().getAttribute("user");
		
		if (user == null) {
			return "redirect:/user/login.do";
		} else {
			boardService.removeBoard(vo);
			return "redirect:getList.do";
		}
	}
}









