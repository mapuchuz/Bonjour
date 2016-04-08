package com.example.bonjour;

import java.io.Serializable;

public class User implements Serializable {

	private String name;
	private String city;
	private String phone;
	private boolean actif;
	
	public User() {
		
	}
	public User(String name, String city, String phone) {
		this.name= name;
		this.city= city;
		this.phone= phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	
	
}
