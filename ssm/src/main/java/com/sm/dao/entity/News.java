package com.sm.dao.entity;
import java.sql.Date;

public class News {
	private Integer id;
	private String contentPage;
	private String contentTitle;
	private Date publishDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContentPage() {
		return contentPage;
	}
	public void setContentPage(String contentPage) {
		this.contentPage = contentPage;
	}
	public String getContentTitle() {
		return contentTitle;
	}
	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	//toString()方法是自动生成的，便于调试时输出对象
	@Override
	public String toString() {
		return "News [id=" + id + ", contentPage=" + contentPage
				+ ", contentTitle=" + contentTitle + ", publishDate="
				+ publishDate + "]";
	}
}
