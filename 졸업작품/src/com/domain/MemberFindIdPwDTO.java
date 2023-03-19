package com.domain;

import java.io.Serializable;

public class MemberFindIdPwDTO implements Serializable{
	private static final long serialVersionUID=1L;
	private String CertificationNum;
	private String name;
	private String mail;
	
	
	public MemberFindIdPwDTO(String certifiString, String name, String mail) {
		super();
		this.CertificationNum=certifiString;
		this.name=name;
		this.mail=mail;
	}
	
	public String getCertificationNum() {
		return CertificationNum;
	}
	public void setCertificationNum(String certificationNum) {
		CertificationNum = certificationNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "MemberFindIdPw [CertificationNum=" + CertificationNum + ", name=" + name + ", mail=" + mail + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CertificationNum == null) ? 0 : CertificationNum.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
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
		MemberFindIdPwDTO other = (MemberFindIdPwDTO) obj;
		if (CertificationNum == null) {
			if (other.CertificationNum != null)
				return false;
		} else if (!CertificationNum.equals(other.CertificationNum))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
