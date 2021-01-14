package controller;

import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.util.ArrayUtils;

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
	public JmsTemplate jmsTemplate;

	@Autowired
	public Queue queueFire;
	
	@PostMapping("/newFire")
	public FireDTO newFire(@RequestBody FireDTO fire) {
		//passerelleService.newFire(fire);
		//socketService.sendNewFire(fire);
		FireDTO savedFire = fireRepository.save(fire);
		jmsTemplate.convertAndSend(queueFire, savedFire);
		return savedFire;
	}


	@PostMapping("/updateFire")
	public void updateFire(@RequestBody FireDTO fire) {
		//passerelleService.newFire(fire);
		//socketService.updateFire(fire);
		FireDTO savedFire = fireRepository.save(fire);
	}

	@GetMapping("/unmanagedFire")
	public List<FireDTO> unmanagedFire(){
		return fireRepository.findByState(FireDTO.stateFire.InOperation.toString());
	}
	
	@GetMapping("/activeFires") 
	public List<FireDTO> listActiveFires() {
		List<FireDTO> firesInOperation = fireRepository.findByState(FireDTO.stateFire.InOperation.toString());
		List<FireDTO> firesInitialize = fireRepository.findByState(FireDTO.stateFire.Initialize.toString());
		firesInOperation.addAll(firesInitialize);
		return firesInOperation;
	}
	
	/*
	 * Endpoint pour la Passerelle-Micro:bit-EM
	 */
	@PostMapping("/newFirePasserelle")
	public FireDTO newFireFromPasserelle(@RequestBody FireDTO fire) {
		socketService.sendNewFire(fire);
		FireDTO savedFire = fireRepository.save(fire);
		//jmsTemplate.convertAndSend(queueFire, savedFire);
		return savedFire;
	}


	/*
	 * Endpoint pour la Passerelle-Micro:bit-EM
	 */
	@PostMapping("/updateFirePasserelle")
	public void updateFirePasserelle(@RequestBody FireDTO fire) {
		socketService.updateFire(fire);
		FireDTO savedFire = fireRepository.save(fire);
	}
}
