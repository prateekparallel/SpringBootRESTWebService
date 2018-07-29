package com.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.car.bean.CarDetailBean;
import com.web.car.bean.CarInfoBean;
import com.web.data.Vehicle;

@Controller
@RequestMapping(path = "/v/vehicle")
public interface VehicleController {
    //Below four different get examples
	@ResponseBody
	public List<Vehicle> getVehicles();

	@ResponseBody
	public Object getVehicleById(@RequestParam("id") int id);
	
	@GetMapping("/{id}/{id2}") 
	@ResponseBody
	public Object getVehicleById(@RequestParam("id") int id, @RequestParam("id2") int id2);
	
	@GetMapping("/{id}/car/{zone}") 
	@ResponseBody
	public Object getVehicleById(@RequestParam("id") int id, @RequestParam("zone") String zone,@RequestParam("user") String user);
	
	//Below two different POST examples#	
	@ResponseBody
	@PostMapping(path = "/orders", consumes = "application/json", produces = "application/json")
	public List<Vehicle> registerCar(CarDetailBean carDetailBean, @RequestHeader(value="user") String user);
	
	@ResponseBody
	@PostMapping(path = "/orderlist/vehicle.json", consumes = "application/json", produces = "application/json")
	public CarInfoBean placeCarOrder(CarInfoBean carInfoBean, @RequestHeader(value="user") String user);
}
