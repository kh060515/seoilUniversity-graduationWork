package com.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MembershipDAO;
import com.domain.MembershipDTO;
import com.domain.SendPaperDTO;
import com.utils.CommandAction;

public class SendMoneyCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sendAccount=request.getParameter("sendForAccountNumber");
		String takeAccount=request.getParameter("account");
		String takeAccountBankName=request.getParameter("selectbk");
		int sendMoney=Integer.parseInt(request.getParameter("sendmoney"));
		String memCode="";
		MembershipDTO logininfo=(MembershipDTO)request.getSession().getAttribute("login");
		memCode=logininfo.getMemcode();
		
		MembershipDAO dao=new MembershipDAO();
		dao.sendmoney(sendAccount,takeAccount,takeAccountBankName,sendMoney,memCode);
		int accountMoney = dao.leftMoney(sendAccount);	//sendpaperdto에 들어갈 남은 잔액을 위한 변수 선언
		SendPaperDTO dto=new SendPaperDTO(sendAccount, takeAccount, takeAccountBankName, sendMoney, accountMoney);
		List<SendPaperDTO> list=new ArrayList<SendPaperDTO>();
		list.add(dto);
		
		return new CommandAction(true, "mainpage.jsp");
	}
}
