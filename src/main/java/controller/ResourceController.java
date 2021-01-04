package controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.FireDTO;
import dto.FireStationDTO;
import repository.FireRepository;
import repository.FireStationRepository;

@RestController
public class ResourceController {

	
	@Autowired
	public FireRepository fireRepository;
	
	@Autowired
	public FireStationRepository fireStationRepository;
	
	@GetMapping("/allFireStation") 
	public List<FireStationDTO> allFireStation() 
	{
		return fireStationRepository.findAll();
	}
	
	

}
