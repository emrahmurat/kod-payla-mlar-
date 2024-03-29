package com.digivet.ws.model.response;

import java.util.Date;

public class CommentRest {
	private String userEmail;
	private String vetEmail;
	private String comment;
	private Date date;
	public CommentRest(String userEmail, String vetEmail, String comment, Date date) {
		super();
		this.userEmail = userEmail;
		this.vetEmail = vetEmail;
		this.comment = comment;
		this.date = date;
	}
	public CommentRest() {
		super();
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getVetEmail() {
		return vetEmail;
	}
	public void setVetEmail(String vetEmail) {
		this.vetEmail = vetEmail;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
