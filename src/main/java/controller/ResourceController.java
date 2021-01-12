package controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.internal.*;
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
	
	@GetMapping("/allTypeFire") 
	public List<TypeFireDTO> allTypeFire()
	{
		return resourceService.getAllTypeFire();
	}
	
	@GetMapping("/allTypeVehicle") 
	public List<TypeVehicleDTO> allTypeVehicle()
	{
		return resourceService.getAllTypeVehicle();
	}

	@GetMapping("/allTVehicle_TFire") 
	public List<J_TVehicle_TFireDTO> allTVehicle_TFire()
	{
		return resourceService.getAllTVehicle_TFire();
	}
	
	@GetMapping("/informationsFireStation") 
	public FireStationInfosDTO getInformationsFireStation(@RequestParam String idFireStation)
	{
		return resourceService.getFireStationInfos(idFireStation);
	}
		
	
}
