package com.domain;

import java.io.Serializable;

public class BankDepositInfoDTO implements Serializable{
	//계좌확인에 사용할 변수를 저장하기 위한 dto
	private static final long serialVersionUID=1L;
	private String name;
	private String acnum;
	private int money;
	
	
	public BankDepositInfoDTO(String name,String acnum,int money) {
		this.name=name;
		this.acnum=acnum;
		this.money=money;
	}
	
	@Override
	public String toString() {
		return "BankDepositInfoDTO [name=" + name + ", acnum=" + acnum + ", money=" + money + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acnum == null) ? 0 : acnum.hashCode());
		result = prime * result + money;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		BankDepositInfoDTO other = (BankDepositInfoDTO) obj;
		if (acnum == null) {
			if (other.acnum != null)
				return false;
		} else if (!acnum.equals(other.acnum))
			return false;
		if (money != other.money)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcnum() {
		return acnum;
	}
	public void setAcnum(String acnum) {
		this.acnum = acnum;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
