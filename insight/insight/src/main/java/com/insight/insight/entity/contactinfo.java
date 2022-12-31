package com.insight.insight.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class contactinfo {
	private String contactinfolocation;
	private String contactinfoemail;
	private String contactinfosisternumber;
	private String contactinfobrothernumber;

	public contactinfo(String contactinfolocation, String contactinfoemail, String contactinfosisternumber,
			String contactinfobrothernumber) {
		super();
		this.contactinfolocation = contactinfolocation;
		this.contactinfoemail = contactinfoemail;
		this.contactinfosisternumber = contactinfosisternumber;
		this.contactinfobrothernumber = contactinfobrothernumber;
	}

	public contactinfo() {

	}

	@Id
	public String getContactinfolocation() {
		return contactinfolocation;
	}

	public void setContactinfolocation(String contactinfolocation) {
		this.contactinfolocation = contactinfolocation;
	}

	public String getContactinfoemail() {
		return contactinfoemail;
	}

	public void setContactinfoemail(String contactinfoemail) {
		this.contactinfoemail = contactinfoemail;
	}

	public String getContactinfosisternumber() {
		return contactinfosisternumber;
	}

	public void setContactinfosisternumber(String contactinfosisternumber) {
		this.contactinfosisternumber = contactinfosisternumber;
	}

	public String getContactinfobrothernumber() {
		return contactinfobrothernumber;
	}

	public void setContactinfobrothernumber(String contactinfobrothernumber) {
		this.contactinfobrothernumber = contactinfobrothernumber;
	}

}
