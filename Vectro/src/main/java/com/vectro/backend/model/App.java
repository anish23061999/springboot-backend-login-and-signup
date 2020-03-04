package com.vectro.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class App {
	
	@Id
	private int id;
	private String fname;
	private String email;
	private String fmail;
	private String phno;
	private String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFmail() {
		return fmail;
	}
	public void setFmail(String fmail) {
		this.fmail = fmail;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public App()
	{
		
	}
	public App(String fname, String email, String fmail, String phno, String location) {
		super();
		this.fname = fname;
		this.email = email;
		this.fmail = fmail;
		this.phno = phno;
		this.location = location;
	}
	@Override
	public String toString() {
		return "App [id=" + id + ", fname=" + fname + ", email=" + email + ", fmail=" + fmail + ", phno=" + phno
				+ ", location=" + location + "]";
	}
	
	
}
