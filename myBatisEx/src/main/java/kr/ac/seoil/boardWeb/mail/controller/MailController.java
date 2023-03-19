package kr.ac.seoil.boardWeb.mail.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.seoil.boardWeb.common.BaseController;
import kr.ac.seoil.boardWeb.mail.service.MailService;
import kr.ac.seoil.boardWeb.mail.vo.MailVO;

@Controller
public class MailController extends BaseController{
	@Autowired
	MailService mailService;
	
	@RequestMapping("/mail/list.do")
	public String list(Model model,MailVO vo,HttpServletRequest request) throws Exception{
		if (super.getUser(request)==null) {
			return "redirect:/user/login.do";
		}
		
		
		List<MailVO> list=mailService.getList(vo);
		model.addAttribute("list",list);
		return "";
	}
}
