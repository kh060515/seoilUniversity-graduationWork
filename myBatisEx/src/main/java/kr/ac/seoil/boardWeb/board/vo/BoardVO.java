package kr.ac.seoil.boardWeb.board.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO implements Serializable {
	private static final long serialVersionUID = -962577965546892872L;
	private int seq;
	private String title;
	private String writerName;
	private String content;
	private Date regDate;
	private int cnt;
	private String searchCondition;
	private String searchKeyword;
	private MultipartFile attach;
	
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchkeyword) {
		this.searchKeyword = searchkeyword;
	}
	public MultipartFile getAttach() {
		return attach;
	}
	public void setAttach(MultipartFile attach) {
		this.attach = attach;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writerName=" + writerName + ", content=" + content
				+ ", regDate=" + regDate + ", cnt=" + cnt + ", searchCondition=" + searchCondition + ", searchkeyword="
				+ searchKeyword + "]";
	}
}
