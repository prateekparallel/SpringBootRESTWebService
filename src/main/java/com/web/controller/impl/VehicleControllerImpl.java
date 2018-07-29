package com.web.controller.impl;

import java.util.List;

import net.minidev.json.JSONObject;

import org.apache.log4j.Logger;


import com.web.data.Vehicle;
import com.web.data.VehicleStore;
import com.web.car.bean.CarDetailBean;
import com.web.car.bean.CarInfoBean;
import com.web.controller.VehicleController;


public class VehicleControllerImpl implements VehicleController{
	private static final Logger LOGGER = Logger.getLogger(VehicleControllerImpl.class);
	//ObjectMapper JSON_MAPPER = new ObjectMapper();
	String result = null;
	
		
	@Override
	public List<Vehicle> getVehicles(){
		
		LOGGER.info("In getVehicles()");
		VehicleStore vehicleStore = VehicleStore.getStoreInstance();
		List<Vehicle> listOfVehicles = vehicleStore.getVehicleList(); 
		JSONObject obj=new JSONObject();
		try{
			obj.put("Vehicles", listOfVehicles);
		}catch(Exception je){
			je.printStackTrace();
			//return Response.status(Status.EXPECTATION_FAILED).entity(je.getMessage()).type(MediaType.APPLICATION_JSON).build();	
		}
		LOGGER.info("Exit getVehicles()");
		return listOfVehicles;	
	}
	
	@Override 
	public Object getVehicleById(int id){
		LOGGER.info("In getVehicleById(int id)");
		LOGGER.info("id :"+id);
		VehicleStore vehicleStore = VehicleStore.getStoreInstance();
		List<Vehicle> listOfVehicles = vehicleStore.getVehicleList(); 
		JSONObject obj=new JSONObject();
		for (Vehicle vehicle: listOfVehicles) { 
			if(vehicle.getId()==id){ 
			try{
				obj.put("Vehicle", vehicle);
				return vehicle;
			}catch(Exception je){
				je.printStackTrace();
				return "Exception occured";	
			}
		  }
			
		}
		return "No Data found";
	}
	
	@Override 
	public Object getVehicleById(int id1, int id2){
		LOGGER.info("In getVehicleById(UriInfo info, int id1, int id2)");
		LOGGER.info("id1 :"+id1);
		LOGGER.info("id2 :"+id2);
		VehicleStore vehicleStore = VehicleStore.getStoreInstance();
		List<Vehicle> listOfVehicles = vehicleStore.getVehicleList();  
		JSONObject obj=new JSONObject();
		boolean vehicleFound = false;
		for (Vehicle vehicle: listOfVehicles) { 
			if(vehicle.getId()==id1 || vehicle.getId()==id2){ 
			try{
				obj.put("Vehicle"+vehicle.getId(), vehicle);
				vehicleFound = true;
			}catch(Exception e){
				e.printStackTrace();
				return "Exception Occured";	
			}
		  }
			
		}
		if(vehicleFound)
			return obj;
		return "No Data found";
	}
	
	@Override 
	public Object getVehicleById(int id,String zone,String user){
		LOGGER.info("In getVehicleById(UriInfo info, int id,String zone,String user)");
		LOGGER.info("id : "+id);
		LOGGER.info("user : "+user);
		LOGGER.info("Zone : "+zone);
		VehicleStore vehicleStore = VehicleStore.getStoreInstance();
		List<Vehicle> listOfVehicles = vehicleStore.getVehicleList();
		JSONObject obj=new JSONObject();
		for (Vehicle vehicle: listOfVehicles) { 
			if(vehicle.getId()==id){ 
			try{
				vehicle.setCountryName("Vehicle From :" + zone);
				return vehicle;
			}catch(Exception e){
				e.printStackTrace();
				return "No Car found";	
			}
		  }
		
		}
		return "No Car found";
	}
	
	@Override
	public List<Vehicle> registerCar(CarDetailBean carDetailBean, String user) {
		LOGGER.info("In registerCar(UriInfo info, CarDetailBean carDetailBean, String user)");
		VehicleStore vehicleStore = VehicleStore.getStoreInstance();
		List<Vehicle> listOfVehicles = vehicleStore.getVehicleList();
		for (Vehicle vehicle: listOfVehicles) { 
			if(vehicle.getId()==carDetailBean.getCarId()){ 
				//return Response.status(Status.EXPECTATION_FAILED).entity("Car id already present. Please use different id").type(MediaType.APPLICATION_JSON).build();
		  }
		
		}
		
		Vehicle newvehicle = new Vehicle(carDetailBean.getCarId(), carDetailBean.getCarInfo());
		vehicleStore.addVehicle(newvehicle);
		LOGGER.info("Exit getVehicles()");
		return listOfVehicles;	
	}
	
	@Override
	public CarInfoBean placeCarOrder(CarInfoBean carInfoBean,  String user) {
		LOGGER.info("In placeCarOrder(CarInfoBean carInfoBean,  String user)");
		return carInfoBean;	
	}	
	
}
