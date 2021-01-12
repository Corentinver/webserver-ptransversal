package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dto.internal.FireDTO;
import repository.FireRepository;

@Service
public class FireService {

	
	public FireRepository fireRepository;
	
	
	
	public List<FireDTO> getInitializedFires() {
		return fireRepository.findByState("Initialize");
	}
	
}
