package com.domain;

import java.io.Serializable;
//sendpaper.jsp에 송금내역서를 출력하기 위한 변수를 저장하기 위한 dto
public class SendPaperDTO implements Serializable{
	private static final long serialVersionUID=1L;
	private String sendAccount;
	private String takeAccount;
	private String takeAccountBankName;
	private int sendMoney;
	private int accountMoney;
	
	public SendPaperDTO(String sendAccount,String takeAccount,String takeAccountBankName,int sendMoney,int accountMoney) {
		super();
		this.sendAccount=sendAccount;
		this.takeAccount=takeAccount;
		this.takeAccountBankName=takeAccountBankName;
		this.sendMoney=sendMoney;
		this.accountMoney=accountMoney;
	}
	
	@Override
	public String toString() {
		return "SendPaperDTO [sendAccount=" + sendAccount + ", takeAccount=" + takeAccount + ", takeAccountBankName="
				+ takeAccountBankName + ", sendMoney=" + sendMoney + ", accountMoney=" + accountMoney + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountMoney;
		result = prime * result + ((sendAccount == null) ? 0 : sendAccount.hashCode());
		result = prime * result + sendMoney;
		result = prime * result + ((takeAccount == null) ? 0 : takeAccount.hashCode());
		result = prime * result + ((takeAccountBankName == null) ? 0 : takeAccountBankName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SendPaperDTO other = (SendPaperDTO) obj;
		if (accountMoney != other.accountMoney)
			return false;
		if (sendAccount == null) {
			if (other.sendAccount != null)
				return false;
		} else if (!sendAccount.equals(other.sendAccount))
			return false;
		if (sendMoney != other.sendMoney)
			return false;
		if (takeAccount == null) {
			if (other.takeAccount != null)
				return false;
		} else if (!takeAccount.equals(other.takeAccount))
			return false;
		if (takeAccountBankName == null) {
			if (other.takeAccountBankName != null)
				return false;
		} else if (!takeAccountBankName.equals(other.takeAccountBankName))
			return false;
		return true;
	}
	public String getSendAccount() {
		return sendAccount;
	}
	public void setSendAccount(String sendAccount) {
		this.sendAccount = sendAccount;
	}
	public String getTakeAccount() {
		return takeAccount;
	}
	public void setTakeAccount(String takeAccount) {
		this.takeAccount = takeAccount;
	}
	public String getTakeAccountBankName() {
		return takeAccountBankName;
	}
	public void setTakeAccountBankName(String takeAccountBankName) {
		this.takeAccountBankName = takeAccountBankName;
	}
	public int getSendMoney() {
		return sendMoney;
	}
	public void setSendMoney(int sendMoney) {
		this.sendMoney = sendMoney;
	}
	public int getAccountMoney() {
		return accountMoney;
	}
	public void setAccountMoney(int accountMoney) {
		this.accountMoney = accountMoney;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
		
}
