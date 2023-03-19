package com.domain;

import java.io.Serializable;
import java.util.Arrays;

public class AccountInfoDTO implements Serializable{
	private static final long serialVersionUID=1L;
	private String sAccountNumber;
	private int credit;
	
	public AccountInfoDTO(String sAccountNumber2,int credit) {
		super();
		this.sAccountNumber=sAccountNumber2;
		this.credit=credit;
	}
	
	@Override
	public String toString() {
		return "AccountInfoDTO [sAccountNumber=" + sAccountNumber + ", credit=" + credit + "]";
	}
	public String getsAccountNumber() {
		return sAccountNumber;
	}
	public void setsAccountNumber(String sAccountNumber) {
		this.sAccountNumber = sAccountNumber;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int i) {
		this.credit = i;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + credit;
		result = prime * result + ((sAccountNumber == null) ? 0 : sAccountNumber.hashCode());
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
		AccountInfoDTO other = (AccountInfoDTO) obj;
		if (credit != other.credit)
			return false;
		if (sAccountNumber == null) {
			if (other.sAccountNumber != null)
				return false;
		} else if (!sAccountNumber.equals(other.sAccountNumber))
			return false;
		return true;
	}
	
	
	
}	
