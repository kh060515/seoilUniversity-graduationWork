package com.contorller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dao.MembershipDAO;
import com.domain.BankDepositInfoDTO;


/**
 * Servlet implementation class AccountNumberCheck
 */
@WebServlet("*.money2")
public class AccountNumberCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountNumberCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("account");	//계좌번호
		String selectbk=request.getParameter("selectbk");	//은행명
		MembershipDAO dao=new MembershipDAO();
		int cnt=0;
		
		//어떠한 은행명이냐에 따라서 송금될 계좌를 구분하기 위한 함수	
		
		if (selectbk.equals("서일은행")) {
			cnt=dao.SeoilBankSendAccountNumberCk(account,selectbk);//서일은행 계좌 확인을 위한 dao함수
		}
		if (selectbk.equals("국미은행")) {
			cnt=dao.KBSendAccountNumberCk(account,selectbk);//국미은행 계좌 확인을 위한 dao함수
		}
		if (selectbk.equals("신하은행")) {
			cnt=dao.SHBankSendAccountNumberCk(account,selectbk);//신하은행 계좌 확인을 위한 dao함수
		}
		if (selectbk.equals("한나은행")) {
			cnt=dao.HABankSendAccountNumberCk(account,selectbk);//한나은행 계좌 확인을 위한 dao함수
		}
		
		JSONObject obj=new JSONObject();
		obj.put("cnt", cnt);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}

}
