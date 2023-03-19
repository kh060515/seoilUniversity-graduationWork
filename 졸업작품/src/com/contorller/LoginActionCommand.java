package com.contorller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.command.Command;
import com.dao.MembershipDAO;
import com.domain.AccountInfoDTO;
import com.domain.MembershipDTO;
import com.utils.CommandAction;



public class LoginActionCommand implements Command {

	@SuppressWarnings("unused")
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		MembershipDAO dao=new MembershipDAO();
		MembershipDTO dto=new MembershipDTO(null, id, pw, null, null, null, null,0);
		
		MembershipDTO login=dao.login(dto);
		
		//ArrayList<AccountInfoDTO> list=dao.CreateAccountInfo(login.getMemcode());
		
		if (login!=null) {		
			HttpSession session=request.getSession();		

			session.setAttribute("login", login);					
			ArrayList<AccountInfoDTO> list=dao.CreateAccountInfo(login.getMemcode());
			if(list==null) {
				list=new ArrayList<AccountInfoDTO>();
				request.setAttribute("err", "not");
				return new CommandAction(false,"loginform.jsp");
			}
			session.setAttribute("list", list);
			return new CommandAction(false, "mainpage.jsp");
		}
		else {
			request.setAttribute("err", "not");
			return new CommandAction(false,"loginform.jsp");
		}		
	}
}
