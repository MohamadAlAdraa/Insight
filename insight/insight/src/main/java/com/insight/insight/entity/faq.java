package com.insight.insight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class faq {
	private Integer idfaq;
	private String faqquestion;
	private String faqanswer;

	public faq(Integer idfaq, String faqquestion, String faqanswer) {
		super();
		this.idfaq = idfaq;
		this.faqquestion = faqquestion;
		this.faqanswer = faqanswer;
	}

	public faq() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdfaq() {
		return idfaq;
	}

	public void setIdfaq(Integer idfaq) {
		this.idfaq = idfaq;
	}

	public String getFaqquestion() {
		return faqquestion;
	}

	public void setFaqquestion(String faqquestion) {
		this.faqquestion = faqquestion;
	}

	public String getFaqanswer() {
		return faqanswer;
	}

	public void setFaqanswer(String faqanswer) {
		this.faqanswer = faqanswer;
	}

}
