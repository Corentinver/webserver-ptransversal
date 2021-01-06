package controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.FireFighterDTO;
import dto.FireStationDTO;
import dto.SensorDTO;
import dto.VehicleDTO;
import service.ResourceService;

@RestController
public class ResourceController {
	
	@Autowired
	public ResourceService resourceService;
	
	@GetMapping("/allFireStation") 
	public List<FireStationDTO> allFireStation() 
	{
		return resourceService.getAllFireStation();
	}

	@GetMapping("/allFireFighter") 
	public List<FireFighterDTO> allFireFighter()
	{
		return resourceService.getAllFireFighter();
	}

	@GetMapping("/allVehicle") 
	public List<VehicleDTO> allVehicle()
	{
		return resourceService.getAllVehicle();
	}

	@GetMapping("/allSensor") 
	public List<SensorDTO> allSensor()
	{
		return resourceService.getAllSensor();
	}
}
