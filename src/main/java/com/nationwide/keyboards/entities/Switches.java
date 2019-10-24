package com.nationwide.keyboards.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Switches {

	@Id
	@GeneratedValue
	private Long id;
	private String manufacturer;
	private String name;
	private String type;
	private int actuation;
	private int tactile;
	private String image;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getActuation() {
		return actuation;
	}
	public void setActuation(int actuation) {
		this.actuation = actuation;
	}
	public int getTactile() {
		return tactile;
	}
	public void setTactile(int tactile) {
		this.tactile = tactile;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
