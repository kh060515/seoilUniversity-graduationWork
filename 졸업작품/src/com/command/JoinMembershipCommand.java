package com.command;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MembershipDAO;
import com.domain.MembershipDTO;
import com.utils.CommandAction;

public class JoinMembershipCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Random rnd=new Random();
		StringBuffer buf=new StringBuffer();
		for(int i=0; i<8; i++)
		{
			if(rnd.nextBoolean())
			{
				buf.append((char)(int)(rnd.nextInt(26)+65));
			}else
			{
				buf.append((rnd.nextInt(10)));
			}
		}
		
		String memcode=String.valueOf(buf);
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String mail=request.getParameter("mail1")+"@"+request.getParameter("mail2");
		String jumin=request.getParameter("jumin1")+"-"+request.getParameter("jumin2");
		
		MembershipDAO dao=new MembershipDAO();
		MembershipDTO dto=new MembershipDTO(memcode, id, pw, name, phone, mail, jumin, 0);
		dao.JoinMember(dto);
		
		return new CommandAction(true, "index.jsp");
	}

}
