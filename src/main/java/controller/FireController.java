package controller;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.internal.FireDTO;
import dto.internal.OperationDTO;
import repository.FireRepository;
import repository.OperationRepository;
import service.PasserelleService;
import service.SocketService;

@RestController
@EnableJms
public class FireController {
	
	@Autowired
	public SocketService socketService;
	
	@Autowired
	public PasserelleService passerelleService; 

	@Autowired
	public FireRepository fireRepository;

	@Autowired
	public OperationRepository operationRepository;

	@Autowired
	public JmsTemplate jmsTemplate;

	@Autowired
	public Queue queueFire;
	
	@PostMapping("/newFire")
	public FireDTO newFire(@RequestBody FireDTO fire) {
		//passerelleService.newFire(fire);
		socketService.sendNewFire(fire);
		FireDTO savedFire = fireRepository.save(fire);
		jmsTemplate.convertAndSend(queueFire, savedFire);
		return savedFire;
	}


	@PostMapping("/updateFire")
	public void updateFire(@RequestBody FireDTO fire) {
		//passerelleService.newFire(fire);
		socketService.sendNewFire(fire);
		FireDTO savedFire = fireRepository.save(fire);
	}


	@PostMapping("/newOperation")
	public void newOperation(@RequestBody OperationDTO operation) {
		//passerelleService.newFire(fire);
		//socketService.sendNewFire(fire);
		operationRepository.save(operation);
		//jmsTemplate.convertAndSend(queueFire, savedFire);
	}

}
