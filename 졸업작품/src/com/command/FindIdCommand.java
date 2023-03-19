package com.command;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MembershipDAO;
import com.domain.MemberFindIdPwDTO;
import com.utils.CommandAction;

public class FindIdCommand implements Command {

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
		
		String CertificationNum=String.valueOf(buf);
		String name=request.getParameter("name");
		String mail=request.getParameter("mail");
		
		MembershipDAO dao=new MembershipDAO();
		MemberFindIdPwDTO dto=new MemberFindIdPwDTO(CertificationNum, name, mail);
		dao.findid(dto);
		
		return new CommandAction(true,"idfindcknum.jsp");
	}

}
