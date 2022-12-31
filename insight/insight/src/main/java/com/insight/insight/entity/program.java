package com.insight.insight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class program {
	private Integer idprogram;
	private String programtitle;
	private String programdefiniton;
	private String programdecription;

	public program(Integer idprogram, String programtitle, String programdefiniton, String programdecription) {
		super();
		this.idprogram = idprogram;
		this.programtitle = programtitle;
		this.programdefiniton = programdefiniton;
		this.programdecription = programdecription;
	}
	
	public program() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdprogram() {
		return idprogram;
	}

	public void setIdprogram(Integer idprogram) {
		this.idprogram = idprogram;
	}

	public String getProgramtitle() {
		return programtitle;
	}

	public void setProgramtitle(String programtitle) {
		this.programtitle = programtitle;
	}

	public String getProgramdefiniton() {
		return programdefiniton;
	}

	public void setProgramdefiniton(String programdefiniton) {
		this.programdefiniton = programdefiniton;
	}

	public String getProgramdecription() {
		return programdecription;
	}

	public void setProgramdecription(String programdecription) {
		this.programdecription = programdecription;
	}

}
