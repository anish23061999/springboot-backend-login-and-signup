package com.vectro.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name="proj")
public class User {

	@Id
	private int id;
	private String name;
	private String mail;
	private String gst;
	private String web;
	private String password;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public User()
	{
		
	}
	public User(String name, String mail, String gst, String web, String password) {
		super();
		this.name = name;
		this.mail = mail;
		this.gst = gst;
		this.web = web;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mail=" + mail + ", gst=" + gst + ", web=" + web + ", password="
				+ password + "]";
	}
	
	
}
