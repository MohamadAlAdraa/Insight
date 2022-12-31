package com.insight.insight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class futureevent {
	private Integer idfutureevent;
	private String futureeventtitle;
	private String futureeventdescription;
	private String futureeventlocation;
	private String futureeventdate;
	private String futureeventimage;

	public futureevent(Integer idfutureevent, String futureeventtitle, String futureeventdescription,
			String futureeventlocation, String futureeventdate, String futureeventimage) {
		super();
		this.idfutureevent = idfutureevent;
		this.futureeventtitle = futureeventtitle;
		this.futureeventdescription = futureeventdescription;
		this.futureeventlocation = futureeventlocation;
		this.futureeventdate = futureeventdate;
		this.futureeventimage = futureeventimage;
	}

	public futureevent() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdfutureevent() {
		return idfutureevent;
	}

	public void setIdfutureevent(Integer idfutureevent) {
		this.idfutureevent = idfutureevent;
	}

	public String getFutureeventtitle() {
		return futureeventtitle;
	}

	public void setFutureeventtitle(String futureeventtitle) {
		this.futureeventtitle = futureeventtitle;
	}

	public String getFutureeventdescription() {
		return futureeventdescription;
	}

	public void setFutureeventdescription(String futureeventdescription) {
		this.futureeventdescription = futureeventdescription;
	}

	public String getFutureeventlocation() {
		return futureeventlocation;
	}

	public void setFutureeventlocation(String futureeventlocation) {
		this.futureeventlocation = futureeventlocation;
	}

	public String getFutureeventdate() {
		return futureeventdate;
	}

	public void setFutureeventdate(String futureeventdate) {
		this.futureeventdate = futureeventdate;
	}

	public String getFutureeventimage() {
		return futureeventimage;
	}

	public void setFutureeventimage(String futureeventimage) {
		this.futureeventimage = futureeventimage;
	}

}
