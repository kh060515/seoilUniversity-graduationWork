package com.command;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MembershipDAO;
import com.domain.MembershipDTO;
import com.function.AccountNumberCreate;
import com.utils.CommandAction;

public class createbkCommand implements Command {
	
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();

		AccountNumberCreate cre=new AccountNumberCreate();
	
		
		String secretnum=request.getParameter("name");
		MembershipDTO logininfo=(MembershipDTO)request.getSession().getAttribute("login");
		String memcode=logininfo.getMemcode();
		String acnum=cre.acnum();
		
		MembershipDAO dao=new MembershipDAO();
		dao.createAccount(secretnum,memcode,acnum);
		return new CommandAction(true,"mainpage.jsp");
	}

}
