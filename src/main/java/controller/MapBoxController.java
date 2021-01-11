package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.internal.PointDTO;
import dto.mapbox.MapBoxDTO;
import service.MapBoxService;

@RestController
public class MapBoxController {

	@Autowired
	public MapBoxService mapBoxService;
	
	@GetMapping("/getRouteLocations")
	public List<PointDTO> getRouteLocations(@RequestParam double startLatitude, @RequestParam double startLongitude,
									@RequestParam double endLatitude, @RequestParam double endLongitude) {
		MapBoxDTO mapBox = mapBoxService.getObjectMapBox(new PointDTO(startLatitude, startLongitude), new PointDTO(endLatitude, endLongitude));	
		return mapBoxService.getListLocations(mapBox);
	}
	
	@GetMapping("/getRouteDuration")
	public double getRouteDuration(@RequestParam double startLatitude, @RequestParam double startLongitude,
			@RequestParam double endLatitude, @RequestParam double endLongitude) {
		MapBoxDTO mapBox = mapBoxService.getObjectMapBox(new PointDTO(startLatitude, startLongitude), new PointDTO(endLatitude, endLongitude));	
		return mapBoxService.getRouteDuration(mapBox);		
	}
			
}
