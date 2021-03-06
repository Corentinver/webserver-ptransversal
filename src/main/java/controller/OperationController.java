package controller;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.internal.OperationDTO;
import dto.internal.RideDTO;
import repository.OperationRepository;
import service.OperationService;
import service.SocketService;

@RestController
public class OperationController {

	@Autowired
	public OperationService operationService;
	
	@Autowired
	public SocketService socketService;

	@Autowired
	public OperationRepository operationRepository;


	@PostMapping("/newOperation")
	public OperationDTO newOperation(@RequestBody OperationDTO operation) {
		OperationDTO savedOperation =  operationRepository.save(operation);
		return savedOperation;
	}
	
	@PostMapping("/sendRide")
	public void newRide(@RequestBody RideDTO ride) {
		socketService.sendRide(ride);
		System.out.println("Fire id : ride : " + ride.operationId);
	}
	
	
	@GetMapping("/operationById")
	public Optional<OperationDTO> getOperationById(@RequestParam String idOperation) {
		return operationRepository.findById(idOperation);
	}
	
}
