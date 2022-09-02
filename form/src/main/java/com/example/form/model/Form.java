package com.example.form.model;

import lombok.Data;

@Data
public class Form {
	
	private String title;
	private String comment;

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title= title; }
	public String getComment() { return comment; }
	public void setComment(String comment) { this.comment = comment; }
}
