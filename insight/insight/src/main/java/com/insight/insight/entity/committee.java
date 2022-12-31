package com.insight.insight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class committee {
	private Integer idcommittee;
	private String committeefullname;
	private String committeeposition;
	private String committeequote;
	private String committeeimage;

	public committee(Integer idcommittee, String committeefullname, String committeeposition, String committeequote,
			String committeeimage) {
		super();
		this.idcommittee = idcommittee;
		this.committeefullname = committeefullname;
		this.committeeposition = committeeposition;
		this.committeequote = committeequote;
		this.committeeimage = committeeimage;
	}

	public committee() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdcommittee() {
		return idcommittee;
	}

	public void setIdcommittee(Integer idcommittee) {
		this.idcommittee = idcommittee;
	}

	public String getCommitteefullname() {
		return committeefullname;
	}

	public void setCommitteefullname(String committeefullname) {
		this.committeefullname = committeefullname;
	}

	public String getCommitteeposition() {
		return committeeposition;
	}

	public void setCommitteeposition(String committeeposition) {
		this.committeeposition = committeeposition;
	}

	public String getCommitteequote() {
		return committeequote;
	}

	public void setCommitteequote(String committeequote) {
		this.committeequote = committeequote;
	}

	public String getCommitteeimage() {
		return committeeimage;
	}

	public void setCommitteeimage(String committeeimage) {
		this.committeeimage = committeeimage;
	}

}
