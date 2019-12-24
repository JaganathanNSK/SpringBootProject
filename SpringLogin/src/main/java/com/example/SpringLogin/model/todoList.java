package com.example.SpringLogin.model;

import java.util.Date;

import javax.validation.constraints.Size;

public class todoList {
   
	private int id;
	private String name;
	
	@Size(min = 10, message = "Dei lusu payale 10 character mela enter pannu da venna")
	private String course;	
	
	private Date date;
	private boolean isdone;
	
	
	
	public todoList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public todoList(int id, String name, String course, Date date, boolean isdone) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.date = date;
		this.isdone = isdone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isIsdone() {
		return isdone;
	}
	public void setIsdone(boolean isdone) {
		this.isdone = isdone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		todoList other = (todoList) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "todoList [id=" + id + ", name=" + name + ", course=" + course + ", date=" + date + ", isdone=" + isdone
				+ "]";
	}
	
	
}
