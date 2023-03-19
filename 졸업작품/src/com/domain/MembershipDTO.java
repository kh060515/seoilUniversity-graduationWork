package com.domain;

import java.io.Serializable;

public class MembershipDTO implements Serializable{
	private static final long serialVersionUID=1L;
	private String memcode;
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String mail;
	private String jumin;
	private int mncheck;
	
	
	
	public MembershipDTO(String memcode, String id, String pw, String name, String phone, String mail, String jumin,
			int mncheck) {
		super();
		this.memcode = memcode;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
		this.jumin = jumin;
		this.mncheck = mncheck;
	}
	
	@Override
	public String toString() {
		return "MembershipDTO [memcode=" + memcode + ", id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone
				+ ", mail=" + mail + ", jumin=" + jumin + ", mncheck=" + mncheck + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jumin == null) ? 0 : jumin.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((memcode == null) ? 0 : memcode.hashCode());
		result = prime * result + mncheck;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
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
		MembershipDTO other = (MembershipDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jumin == null) {
			if (other.jumin != null)
				return false;
		} else if (!jumin.equals(other.jumin))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (memcode == null) {
			if (other.memcode != null)
				return false;
		} else if (!memcode.equals(other.memcode))
			return false;
		if (mncheck != other.mncheck)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		return true;
	}
	public String getMemcode() {
		return memcode;
	}
	public void setMemcode(String memcode) {
		this.memcode = memcode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public int getMncheck() {
		return mncheck;
	}
	public void setMncheck(int mncheck) {
		this.mncheck = mncheck;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
		
	
}
