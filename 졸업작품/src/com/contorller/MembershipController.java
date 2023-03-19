package com.contorller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.command.CreaAcNumCommand;
import com.command.FindIdCommand;
import com.command.FindPwCommand;
import com.command.InquiryCommand;
import com.command.JoinMembershipCommand;
import com.command.JoinMembershipUICommand;
import com.command.LogoutCommand;
import com.command.NumcksubmitCommand;
import com.command.SendMoneyCommand;
import com.command.createbkCommand;
import com.command.pwNumcksubmitCommand;
import com.utils.CommandAction;

/**
 * Servlet implementation class Membership
 */
@WebServlet("*.do")
public class MembershipController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MembershipController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri=request.getRequestURI();
		String ctxp=request.getContextPath();
		String sp=uri.substring(ctxp.length());
		Command com=null;
		
		if (sp.equalsIgnoreCase("/JoinMembership.do")) {
			com=new JoinMembershipCommand();			
		}else if (sp.equalsIgnoreCase("/JoinMembershipUI.do")) {
			com=new JoinMembershipUICommand();
		}else if (sp.equalsIgnoreCase("/loginaction.do")) {
			com=new LoginActionCommand();
		}else if(sp.equalsIgnoreCase("/logout.do")){
			com=new LogoutCommand();
		}else if(sp.equalsIgnoreCase("/findId.do")) {
			com=new FindIdCommand();
		}else if(sp.equalsIgnoreCase("/numcksubmit.do")) {
			com=new NumcksubmitCommand();
		}else if(sp.equalsIgnoreCase("/findpw.do")) {
			com=new FindPwCommand();
		}else if(sp.equalsIgnoreCase("/pwnumcksubmit.do")) {
			com=new pwNumcksubmitCommand();
		}else if(sp.equalsIgnoreCase("/createbk.do")) {
			com=new createbkCommand();
		}else if(sp.equalsIgnoreCase("/creaAcNum.do")) {
			com=new CreaAcNumCommand();
		}else if(sp.equalsIgnoreCase("/inquiry.do")) {
			com=new InquiryCommand();
		}else if(sp.equalsIgnoreCase("/sendmoney.do")) {
			com=new SendMoneyCommand();
		}
		
		
		if(com!=null) {
			CommandAction action=com.execute(request, response);
			if(action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			}else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
}
