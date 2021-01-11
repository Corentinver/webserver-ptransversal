package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.internal.FireDTO;
import repository.FireRepository;
import service.PasserelleService;
import service.SocketService;

@RestController
public class FireController {

	@Autowired
	public SocketService socketService;
	
	@Autowired
	public PasserelleService passerelleService; 

	@Autowired
	public FireRepository fireRepository;
	
	@PostMapping("/newFire")
	public void newFire(@RequestBody FireDTO fire) {
		passerelleService.newFire(fire);
		socketService.sendNewFire(fire);
		fireRepository.save(fire);
	}

}
