package kr.ac.seoil.boardWeb.mail.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.seoil.boardWeb.mail.service.MailService;
import kr.ac.seoil.boardWeb.mail.vo.MailVO;

@Service("mailService")
public class MailServiceImpl implements MailService{
	@Resource(name="mailDAO")//의존관계를 이렇게하면 시작할때 자동적으로  mailDAO가 new되면서 시작된다.
	MailDAO mailDAO;
	
	@Override
	public List<MailVO> getList(MailVO vo) throws Exception {
		return MailDAO.selectList(vo);
	}
}
