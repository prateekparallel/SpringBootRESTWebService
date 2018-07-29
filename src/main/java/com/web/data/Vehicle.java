package com.web.data;

import java.io.Serializable;

//@JsonPropertyOrder({"id", "VehicleName"})

public class Vehicle implements Serializable{
	
	private static final long serialVersionUID = -3501772243949297054L;
	
	private int id;
	
	private String vehicleName; 
	
	private String countryName;
	
	public Vehicle(){};
	public Vehicle(int i, String vehicleName){ 
		super(); 
		this.id = i; 
		this.vehicleName = vehicleName; 
	} 
	
	public int getId(){ 
		return id; 
	} 
	
	public void setId(int id) { 
		this.id = id; 
		
	} 
	
	public String getVehicleName() { 
		return vehicleName; 
	} 
	
	public void setVehicleName(String vehicleName) { 
		this.vehicleName = vehicleName; 
	} 
	
	public String getCountryName() { 
		return countryName; 
	} 
	
	public void setCountryName(String countryName) { 
		this.countryName = countryName; 
	} 
}
