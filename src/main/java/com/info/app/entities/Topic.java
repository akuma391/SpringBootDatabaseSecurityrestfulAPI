package com.info.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="topics")
public class Topic implements Serializable {
	
	private static final long serialVerionUID=1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	

	private int topicId;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="category")
	private String category;

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
