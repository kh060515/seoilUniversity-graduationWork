package kr.ac.seoil.boardWeb.mail.service;

import java.util.List;

import kr.ac.seoil.boardWeb.mail.vo.MailVO;

public interface MailService {
	List<MailVO> getList(MailVO vo) throws Exception;
}
