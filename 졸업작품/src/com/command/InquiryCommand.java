package com.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MembershipDAO;
import com.domain.MembershipDTO;
import com.utils.CommandAction;

public class InquiryCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MembershipDTO login=(MembershipDTO) request.getSession().getAttribute("login");
		MembershipDAO dao=new MembershipDAO();
		int inquiryNumber=dao.inquiryNum();
		inquiryNumber=inquiryNumber+1;
		String memcode=login.getMemcode();
		String email=request.getParameter("mail");
		String title=request.getParameter("title");
		String contents=request.getParameter("content");
		
		dao.InputInquiry(inquiryNumber,memcode,email,title,contents);
		
		return new CommandAction(false,"mainpage.jsp");
	}

}
