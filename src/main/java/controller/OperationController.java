package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.internal.RideDTO;
import service.OperationService;
import service.SocketService;

@RestController
public class OperationController {

	@Autowired
	public OperationService operationService;
	
	@Autowired
	public SocketService socketService;
	
	
	@PostMapping("/sendRide")
	public void newRide(@RequestBody RideDTO ride) {
		socketService.sendRide(ride);
	}
	
	
}
