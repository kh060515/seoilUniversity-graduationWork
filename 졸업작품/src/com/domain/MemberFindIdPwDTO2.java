package com.domain;

import java.io.Serializable;

public class MemberFindIdPwDTO2 implements Serializable{
	private static final long serialVersionUID=1L;
	private String CertificationNum;
	private String id;
	private String mail;
	
	
	public MemberFindIdPwDTO2(String certifiString, String id, String mail) {
		super();
		this.CertificationNum=certifiString;
		this.id=id;
		this.mail=mail;
	}
	
	public String getCertificationNum() {
		return CertificationNum;
	}
	public void setCertificationNum(String certificationNum) {
		CertificationNum = certificationNum;
	}
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
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
		return "MemberFindIdPw [CertificationNum=" + CertificationNum + ", id=" + id + ", mail=" + mail + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CertificationNum == null) ? 0 : CertificationNum.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		MemberFindIdPwDTO2 other = (MemberFindIdPwDTO2) obj;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
