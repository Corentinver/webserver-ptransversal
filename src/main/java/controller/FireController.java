package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.FireDTO;
import repository.FireRepository;
import service.SocketService;

@RestController
public class FireController {

	@Autowired
	public SocketService socketService;
	
	@Autowired
	public FireRepository fireRepository;
	
	@PostMapping("/newFire")
	public void newFire(@RequestBody FireDTO fire) {
		socketService.sendNewFire(fire);
		
		fireRepository.save(fire);
	}

}
