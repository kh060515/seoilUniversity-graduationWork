package com.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MembershipDAO;
import com.utils.CommandAction;

public class pwNumcksubmitCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cknum=request.getParameter("cknum");
		MembershipDAO dao=new MembershipDAO();
		dao.checkpwnum(cknum);
		
		return new CommandAction(true, "mainpage.jsp");
	}

}
