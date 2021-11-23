package com.api.ApiTask.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "Id")
	private long id;

	@Column(name = "Title")
	private String title;

	@Column(name = "Description")
	private String description;

	public Course(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;

	}

	public Course(int id, String description) {
		super();
		this.id = id;
		this.description = description;

	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", description=" + description + "]";
	}

}
