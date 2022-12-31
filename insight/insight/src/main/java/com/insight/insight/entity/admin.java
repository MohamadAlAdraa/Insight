package com.insight.insight.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class admin {
	private String adminfirstname;
	private String adminlastname;
	private String adminemail;
	private String adminpassword;

	public admin(String adminfirstname, String adminlastname, String adminemail, String adminpassword) {
		super();
		this.adminfirstname = adminfirstname;
		this.adminlastname = adminlastname;
		this.adminemail = adminemail;
		this.adminpassword = adminpassword;
	}

	public admin() {

	}

	@Id
	public String getAdminemail() {
		return adminemail;
	}

	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}

	public String getAdminfirstname() {
		return adminfirstname;
	}

	public void setAdminfirstname(String adminfirstname) {
		this.adminfirstname = adminfirstname;
	}

	public String getAdminlastname() {
		return adminlastname;
	}

	public void setAdminlastname(String adminlastname) {
		this.adminlastname = adminlastname;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

}
