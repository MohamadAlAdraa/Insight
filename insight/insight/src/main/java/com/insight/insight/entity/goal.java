package com.insight.insight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class goal {
	private Integer idgoal;
	private String goaltitle;
	private String goalayah;

	public goal(Integer idgoal, String goaltitle, String goalayah) {
		super();
		this.idgoal = idgoal;
		this.goaltitle = goaltitle;
		this.goalayah = goalayah;
	}
	
	public goal() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdgoal() {
		return idgoal;
	}

	public void setIdgoal(Integer idgoal) {
		this.idgoal = idgoal;
	}

	public String getGoaltitle() {
		return goaltitle;
	}

	public void setGoaltitle(String goaltitle) {
		this.goaltitle = goaltitle;
	}

	public String getGoalayah() {
		return goalayah;
	}

	public void setGoalayah(String goalayah) {
		this.goalayah = goalayah;
	}

}
