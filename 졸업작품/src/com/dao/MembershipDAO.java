package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.domain.AccountInfoDTO;
import com.domain.MemberFindIdPwDTO;
import com.domain.MemberFindIdPwDTO2;
import com.domain.MembershipDTO;
import com.function.MailExam;
import com.function.MailExam2;


public class MembershipDAO {
	private DataSource dataFctory;
	public MembershipDAO() {
		try {
			Context ctx=new InitialContext();
			dataFctory=(DataSource)ctx.lookup("java:comp/env/jdbc/oracle11g");		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		try {
			if (rs!=null) {
				rs.close();
			}
			if (pstmt!=null) {
				pstmt.close();
			}
			if (conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void JoinMember(MembershipDTO dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="insert into meminfo (memcode,memid,mempw,csname,phonenum,juminnum,email) values (?,?,?,?,?,?,?)";
		
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getMemcode());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getName());
			pstmt.setString(5, dto.getPhone());
			pstmt.setString(6, dto.getJumin());
			pstmt.setString(7, dto.getMail());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
	}

	public int idcheck(String id) {
		int cnt=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="select count(*) as cnt from meminfo where memid=?";
		ResultSet rs=null;
		
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			
			rs=pstmt.executeQuery();			
			if (rs.next()) {
				cnt=rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return cnt;
	}

	public int phonecheck(String phone) {
		int cnt=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="select count(*) as cnt from meminfo where phonenum=?";
		ResultSet rs=null;
		
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,phone);
			
			rs=pstmt.executeQuery();
			if (rs.next()) {
				cnt=rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return cnt;
	}

	public int mailcheck(String mail) {
		int cnt=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="select count(*) as cnt from meminfo where email=?";
		ResultSet rs=null;
		
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,mail);
			
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				cnt=rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		
		return cnt;
	}
	
	public int jumincheck(String jumin) {
		int cnt=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="select count(*) as cnt from meminfo where juminnum=?";
		ResultSet rs=null;
		
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,jumin);
			
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				cnt=rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		
		return cnt;
	}
		
	public MembershipDTO login(MembershipDTO dto) {
		MembershipDTO login=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select memcode,memid,csname,juminnum,email,mncheck from meminfo where memid=? and mempw=?";
		
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			rs=pstmt.executeQuery();	
			
			while(rs.next()) {
				String memcode=rs.getString("memcode");
				String id=rs.getString("memid");
				String name=rs.getString("csname");
				String juminNum=rs.getString("juminnum");
				String email=rs.getString("email");
				int mncheck=rs.getInt("mncheck");
				login=new MembershipDTO(memcode, id, null, name, null, email, juminNum, mncheck);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		
		return login;
	}
	public ArrayList<AccountInfoDTO> CreateAccountInfo(String memcode) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select acnum,money from acinfo where memcode=?";
		ArrayList<AccountInfoDTO> list=new ArrayList<AccountInfoDTO>();
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);		
			pstmt.setString(1, memcode);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				AccountInfoDTO login2=new AccountInfoDTO(null, 0);
				login2.setCredit(rs.getInt("money"));
				login2.setsAccountNumber(rs.getString("acnum"));
				list.add(login2);
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public void findid(MemberFindIdPwDTO dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="insert into idnumcheck (certificationNum,name,mail) values (?,?,?)";
		String sql2="select mail from idnumcheck where mail=?";
		String sql3="update idnumcheck set certificationNum=? where mail=?";
		String email=null;
		String sentence=null;
		
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql2);
			pstmt.setString(1, dto.getMail());
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				email=rs.getString("mail");
			}			
			closeAll(conn, pstmt, rs);
			
			if (email!=null) {
				conn=dataFctory.getConnection();
				pstmt=conn.prepareStatement(sql3);
				pstmt.setString(1, dto.getCertificationNum());
				pstmt.setString(2, dto.getMail());
				email=dto.getMail();
				sentence=dto.getCertificationNum();
				
				pstmt.executeUpdate();				
			}else {				
				conn=dataFctory.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, dto.getCertificationNum());
				pstmt.setString(2, dto.getName());
				pstmt.setString(3, dto.getMail());
				email=dto.getMail();
				sentence=dto.getCertificationNum();
				
				pstmt.executeUpdate();
			}
					
			MailExam.main(email, sentence);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
	}
	
	
	public void checkidnum(String sNum) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sId=null;
		String sMail=null;
		String sql="select memid,email from meminfo where csname=(select name from idnumcheck where certificationNum=?) and email=(select email from idnumcheck where certificationNum=?)";		
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sNum);
			pstmt.setString(2, sNum);
			rs=pstmt.executeQuery();										
			
			while(rs.next())
			{
				sId=rs.getString("memid");
				sMail=rs.getString("email");
			}
			MailExam2.main(sMail,"소유하신 아이디 입니다: "+sId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);			
		}
	}
	public void checkpwnum(String cknum) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sPw=null;
		String sMail=null;
		String sql="select mempw,email from meminfo where memid=(select id from pwnumcheck where certificationNum=?) and email=(select email from pwnumcheck where certificationNum=?)";		
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cknum);
			pstmt.setString(2, cknum);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				sPw=rs.getString("mempw");
				sMail=rs.getString("email");
			}
			MailExam2.main(sMail,"찾으시는 비밀번호는 "+sPw+" 입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
	}

	public int mailcheck2(String mail) {
		int cnt=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="select count(*) as cnt from meminfo where email=?";
		ResultSet rs=null;
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,mail);
			
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				cnt=rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		
		return cnt;
	}

	public int cknumcheck(String cknum) {
		int cnt=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(*) as cnt from idnumcheck where certificationnum=?";
		
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cknum);
						
			rs=pstmt.executeQuery();			
			if (rs.next()) {
				cnt=rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return cnt;
	}
	public int pwcknumcheck(String cknum) {
		int cnt=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(*) as cnt from pwnumcheck where certificationnum=?";
		
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cknum);
						
			rs=pstmt.executeQuery();			
			if (rs.next()) {
				cnt=rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return cnt;
	}


	public void findPw(MemberFindIdPwDTO2 dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="insert into pwnumcheck (certificationNum,id,mail) values (?,?,?)";
		String sql2="select mail from pwnumcheck where mail=?";
		String sql3="update pwnumcheck set certificationNum=? where mail=?";
		String email=null;
		String sentence=null;
		
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql2);
			pstmt.setString(1, dto.getMail());
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				email=rs.getString("mail");
			}			
			closeAll(conn, pstmt, rs);
			
			if (email!=null) {
				conn=dataFctory.getConnection();
				pstmt=conn.prepareStatement(sql3);
				pstmt.setString(1, dto.getCertificationNum());
				pstmt.setString(2, dto.getMail());
				email=dto.getMail();
				sentence=dto.getCertificationNum();
				
				pstmt.executeUpdate();				
			}else {				
				conn=dataFctory.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, dto.getCertificationNum());
				pstmt.setString(2, dto.getid());
				pstmt.setString(3, dto.getMail());
				email=dto.getMail();
				sentence=dto.getCertificationNum();
				
				pstmt.executeUpdate();
			}
					
			MailExam.main(email, sentence);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
	}

	public void createAccount(String secretnum, String memcode, String acnum) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="insert into acinfo (acnum,memcode,secretnum) values (?,?,?)";
		
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, acnum);
			pstmt.setString(2, memcode);
			pstmt.setString(3, secretnum);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
	}

	public void creaAc(String certificationNum, String memcode, String mail) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="insert into cracnumcheck (certificationNum,memcode,mail) values (?,?,?)";
		String sql2="select count(*) as cnt from cracnumcheck where mail=?";
		String sql3="update cracnumcheck set certificationNum=? where mail=?";
		int cnt=0;
		String email=null;
		String sentence=null;
		
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql2);
			pstmt.setString(1, mail);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				cnt=rs.getInt("cnt");
			}			
			closeAll(conn, pstmt, rs);
			
			if (cnt==1) {
				
				conn=dataFctory.getConnection();
				pstmt=conn.prepareStatement(sql3);
				pstmt.setString(1, certificationNum);
				pstmt.setString(2, mail);
				email=mail;
				sentence=certificationNum;				
				pstmt.executeUpdate();				
			}else if(cnt==0) {		
				
				conn=dataFctory.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, certificationNum);
				pstmt.setString(2, memcode);
				pstmt.setString(3, mail);
				email=mail;
				sentence=certificationNum;
				
				pstmt.executeUpdate();
			}
				
			MailExam.main(email, sentence);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
	}

	public int accknumcheck(String cknum) {
		int cnt=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(*) as cnt from cracnumcheck where certificationnum=?";
		
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cknum);
						
			rs=pstmt.executeQuery();			
			if (rs.next()) {
				cnt=rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return cnt;
	}

	public int AccountCount(String memcode) {
		int cnt=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(*) as cnt from acinfo where memcode=?";
		
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memcode);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				cnt=rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		
		return cnt;
	}

	public int inquiryNum() {
		int inquirycount=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(*) as cnt from board";
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				inquirycount=rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return inquirycount;
	}

	public void InputInquiry(int inquiryNumber, String memcode, String email, String title, String contents) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="insert into board values (?,?,?,?,?)";
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, inquiryNumber);
			pstmt.setString(2, memcode);
			pstmt.setString(3, email);
			pstmt.setString(4, title);
			pstmt.setString(5, contents);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
	}
	
	public int SeoilBankSendAccountNumberCk(String account, String selectbk) {
		//서일은행 계좌정보 유효성 확인을 위한 함수
		int cnt=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(*) as cnt from acinfo where acnum=?";
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, account);
			rs=pstmt.executeQuery();	
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return cnt;
	}
	
	public int KBSendAccountNumberCk(String account, String selectbk) {
		int cnt=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(*) as cnt from tempkb where acnum=?";
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, account);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				cnt=rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		
		return cnt;
	}

	public int SHBankSendAccountNumberCk(String account, String selectbk) {
		//신하은행 계좌 유효성 검사를 위한 함수
		int cnt=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(*) as cnt from tempsh where acnum=?";
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, account);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return cnt;
	}

	public int HABankSendAccountNumberCk(String account, String selectbk) {
		//한나은행 계좌 유효성 검사를 위한 함수
		int cnt=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select count(*) as cnt from tempha where acnum=?";
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, account);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return cnt;
	}

	public void sendmoney(String sendAccount, String takeAccount, String takeAccountBankName, int sendMoney,String memCode) {
		//jsp에서전송된 데이터를 기반으로 계좌정도 업데이트 및 거래내역 추가하는 함수
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";	//송금된 금액을 정해진 계좌로 넣어주기 위한 명령어
		String sql4="update acinfo set money=money-? where acnum=?";	//송금하기로 한 금액만큼 계좌에서 차감하기 위한 sql문
		if(takeAccountBankName.equals("국미은행")) {
			//은행명에 따라서 계좌들의 정보를 변경해주기 위한 sql문을 적용시키기 위한 if문
			sql="update tempkb set money=money+? where acnum=?";
		}else if(takeAccountBankName.equals("신하은행")) {
			sql="update tempsh set money=money+? where acnum=?";
		}else if(takeAccountBankName.equals("한나은행")) {
			sql="update tempha set money=money+? where acnum=?";
		}else if(takeAccountBankName.equals("서일은행")) {
			sql="update acinfo set money=money+? where acnum=?";
		}
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sendMoney);
			pstmt.setString(2, takeAccount);
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		
		//입금하기로 한 금액만큼 계좌에서 금액을 차감하기 위한 코드
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql4);
			pstmt.setInt(1, sendMoney);
			pstmt.setString(2, sendAccount);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		
		//거래번호를 구하기 위한 코드
		int cnt=0;	//memcode마다 거래한 거래내역의 거래번호를 담기 위한 변수
		String sql2="select count(*) as cnt from trninfo where memcode=?";
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql2);
			pstmt.setString(1, memCode);
			rs=pstmt.executeQuery();			
			if(rs.next()) {
				do {
					cnt=rs.getInt("cnt")+1;
				}while(rs.next());
			}else {
				cnt=1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		
		//거래내역 db에 추가하기 위한 코드
		String sql3="insert into trninfo values (?,?,?,?,?,?)";	//거래내역 테이블에 항목을 추가하기 위한 sql문
		SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm");	//거래가 언제 발생했는지 알기 위한 현재 시간 구하는 변수
		Date time=new Date();
		String trnTime=format1.format(time);
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql3);
			pstmt.setInt(1, cnt);
			pstmt.setString(2, sendAccount);
			pstmt.setString(3, memCode);
			pstmt.setInt(4, sendMoney);
			pstmt.setString(5, takeAccount);
			pstmt.setString(6, trnTime);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
	}

	public int leftMoney(String sendAccount) {
		//송금 후의 잔액을 가져오기 위한 함수
		int iLeftMoney=0;
		String sql="select money from acinfo where acnum=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=dataFctory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sendAccount);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				iLeftMoney=rs.getInt("money");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return iLeftMoney;
	}
}
