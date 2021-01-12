package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dto.internal.PointDTO;
import dto.mapbox.MapBoxDTO;

@Service
public class MapBoxService {

	@Autowired
	public RestTemplate restTemplate;
	
    @Value("${tokenmapbox}")
    private String token;
	
	public MapBoxDTO getObjectMapBox(PointDTO startLocation, PointDTO endLocation) {
		return restTemplate.getForObject("https://api.mapbox.com/directions/v5/mapbox/driving/" +
				startLocation.getLongitude() + "," + startLocation.getLatitude() + ";" +
				endLocation.getLongitude() + "," + endLocation.getLatitude() +
				"?geometries=geojson&language=fr&access_token=" + token, MapBoxDTO.class);
	}
	
	
	public List<PointDTO> getListLocations(MapBoxDTO mapBox) {
		List<PointDTO> listLocations = new ArrayList<PointDTO>();
		if (mapBox != null && mapBox.getRoutes().size() > 0) {
			mapBox.getRoutes().get(0).getGeometry().getCoordinates().forEach(l -> listLocations.add(new PointDTO(l.get(1), l.get(0))));
		}
		return listLocations;
	}
	
	public double getRouteDuration(MapBoxDTO mapBox) {
		if (mapBox != null && mapBox.getRoutes().size() > 0) {
			return mapBox.getRoutes().get(0).getDuration();
		}
		return 0;
	}
	
}
