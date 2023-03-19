package com.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MembershipDAO;
import com.utils.CommandAction;

public class NumcksubmitCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sNum=request.getParameter("num3");
		MembershipDAO dao=new MembershipDAO();
		dao.checkidnum(sNum);
		
		return new CommandAction(true,"mainpage.jsp");
	}

}
