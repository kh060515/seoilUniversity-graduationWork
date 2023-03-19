package kr.ac.seoil.boardWeb.mail.vo;

import java.util.Date;

public class MailVO {
	private String sender;
	private String receiver;
	private String title;
	private String content;
	private Date sendDate;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	@Override
	public String toString() {
		return "MailVO [sender=" + sender + ", receiver=" + receiver + ", title=" + title + ", content=" + content
				+ ", sendDate=" + sendDate + "]";
	}

	
}
