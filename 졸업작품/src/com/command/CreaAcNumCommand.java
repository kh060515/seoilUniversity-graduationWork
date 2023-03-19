package com.command;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MembershipDAO;
import com.domain.MembershipDTO;
import com.utils.CommandAction;

public class CreaAcNumCommand implements Command {

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
		HttpSession session=request.getSession();
		String CertificationNum=String.valueOf(buf);
		MembershipDTO logininfo=(MembershipDTO)request.getSession().getAttribute("login");
		String memcode=logininfo.getMemcode();
		String mail=request.getParameter("mail");

		MembershipDAO dao=new MembershipDAO();
		dao.creaAc(CertificationNum,memcode,mail);
		return new CommandAction(false,"mainpag.jsp");
	}

}
