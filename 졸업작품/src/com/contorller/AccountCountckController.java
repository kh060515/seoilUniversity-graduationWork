package com.contorller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.dao.MembershipDAO;
import com.domain.MembershipDTO;

/**
 * Servlet implementation class cknumberCheckController
 */
@WebServlet("*.countCk")
public class AccountCountckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountCountckController() {
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
		
		MembershipDAO dao=new MembershipDAO();
		MembershipDTO logininfo=(MembershipDTO)request.getSession().getAttribute("login");
		String memcode=logininfo.getMemcode();
		int cnt=dao.AccountCount(memcode);
		
		JSONObject obj=new JSONObject();
		obj.put("cnt", cnt);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
	}

}
