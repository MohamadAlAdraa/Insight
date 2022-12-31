package com.insight.insight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class previousevent {
	private Integer idpreviousevent;
	private String previouseventtitle;
	private String previouseventdescription;
	private String previouseventgallery;
	private String previouseventimage;

	public previousevent(Integer idpreviousevent, String previouseventtitle, String previouseventdescription,
			String previouseventgallery, String previouseventimage) {
		super();
		this.idpreviousevent = idpreviousevent;
		this.previouseventtitle = previouseventtitle;
		this.previouseventdescription = previouseventdescription;
		this.previouseventgallery = previouseventgallery;
		this.previouseventimage = previouseventimage;
	}
	
	public previousevent() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdpreviousevent() {
		return idpreviousevent;
	}

	public void setIdpreviousevent(Integer idpreviousevent) {
		this.idpreviousevent = idpreviousevent;
	}

	public String getPreviouseventtitle() {
		return previouseventtitle;
	}

	public void setPreviouseventtitle(String previouseventtitle) {
		this.previouseventtitle = previouseventtitle;
	}

	public String getPreviouseventdescription() {
		return previouseventdescription;
	}

	public void setPreviouseventdescription(String previouseventdescription) {
		this.previouseventdescription = previouseventdescription;
	}

	public String getPreviouseventgallery() {
		return previouseventgallery;
	}

	public void setPreviouseventgallery(String previouseventgallery) {
		this.previouseventgallery = previouseventgallery;
	}

	public String getPreviouseventimage() {
		return previouseventimage;
	}

	public void setPreviouseventimage(String previouseventimage) {
		this.previouseventimage = previouseventimage;
	}

}
