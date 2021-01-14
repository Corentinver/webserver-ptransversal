package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.mongodb.client.model.geojson.Point;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.internal.*;
import dto.mapbox.MapBoxDTO;
import service.MapBoxService;
import service.ResourceService;

@RestController
public class ResourceController {
	
	@Autowired
	public ResourceService resourceService;

	@Autowired
	public MapBoxService mapBoxService;
	
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

	@GetMapping("/vehicleLocation") 
	public PointDTO getLocationByVehicle(@RequestHeader String idVehicle)
	{
		System.out.println(idVehicle);
		return resourceService.getPointDTOByVehicle(idVehicle);
	}
	
	
	@GetMapping("/getMapFireStationByDistance") 
	public HashMap getMapFireStationByDistance(@RequestHeader double endLatitude, @RequestHeader double endLongitude)
	{
		List<FireStationDTO> fireStations = resourceService.getAllFireStation();
		HashMap<Double, String> fireStationMap = new HashMap<Double, String>();
        for(FireStationDTO f : fireStations){
			MapBoxDTO mapBox = mapBoxService.getObjectMapBox(new PointDTO(f.location.latitude, f.location.longitude), new PointDTO(endLatitude, endLongitude));
            fireStationMap.put(mapBoxService.getRouteDuration(mapBox), f.id);
		}

		return fireStationMap;
	}

	@GetMapping("/ressourcesFireStation")
	public FireStationResourcesDTO getFireStationResourcesAvailable(@RequestHeader String idFireStation){
		return resourceService.getFireStationResourcesAvailable(idFireStation);
	}
	
		
	
}
