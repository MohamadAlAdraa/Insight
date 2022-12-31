package com.insight.insight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class blog {
	private Integer idblog;
	private String blogtitle;
	private String blogwriter;
	private String blogdate;
	private String blogcontent;
	private String blogimage;

	public blog(Integer idblog, String blogtitle, String blogwriter, String blogdate, String blogcontent,
			String blogimage) {
		super();
		this.idblog = idblog;
		this.blogtitle = blogtitle;
		this.blogwriter = blogwriter;
		this.blogdate = blogdate;
		this.blogcontent = blogcontent;
		this.blogimage = blogimage;
	}

	public blog() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdblog() {
		return idblog;
	}

	public void setIdblog(Integer idblog) {
		this.idblog = idblog;
	}

	public String getBlogtitle() {
		return blogtitle;
	}

	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}

	public String getBlogwriter() {
		return blogwriter;
	}

	public void setBlogwriter(String blogwriter) {
		this.blogwriter = blogwriter;
	}

	public String getBlogdate() {
		return blogdate;
	}

	public void setBlogdate(String blogdate) {
		this.blogdate = blogdate;
	}

	public String getBlogcontent() {
		return blogcontent;
	}

	public void setBlogcontent(String blogcontent) {
		this.blogcontent = blogcontent;
	}

	public String getBlogimage() {
		return blogimage;
	}

	public void setBlogimage(String blogimage) {
		this.blogimage = blogimage;
	}

}
