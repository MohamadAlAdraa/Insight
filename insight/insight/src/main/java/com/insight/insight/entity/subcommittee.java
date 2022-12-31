package com.insight.insight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class subcommittee {
	private Integer idsubcommittee;
	private String subcommitteetitle;
	private String subcommitteedescription;
	private String subcommitteeimage;

	public subcommittee(Integer idsubcommittee, String subcommitteetitle, String subcommitteedescription,
			String subcommitteeimage) {
		super();
		this.idsubcommittee = idsubcommittee;
		this.subcommitteetitle = subcommitteetitle;
		this.subcommitteedescription = subcommitteedescription;
		this.subcommitteeimage = subcommitteeimage;
	}

	public subcommittee() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdsubcommittee() {
		return idsubcommittee;
	}

	public void setIdsubcommittee(Integer idsubcommittee) {
		this.idsubcommittee = idsubcommittee;
	}

	public String getSubcommitteetitle() {
		return subcommitteetitle;
	}

	public void setSubcommitteetitle(String subcommitteetitle) {
		this.subcommitteetitle = subcommitteetitle;
	}

	public String getSubcommitteedescription() {
		return subcommitteedescription;
	}

	public void setSubcommitteedescription(String subcommitteedescription) {
		this.subcommitteedescription = subcommitteedescription;
	}

	public String getSubcommitteeimage() {
		return subcommitteeimage;
	}

	public void setSubcommitteeimage(String subcommitteeimage) {
		this.subcommitteeimage = subcommitteeimage;
	}
}
