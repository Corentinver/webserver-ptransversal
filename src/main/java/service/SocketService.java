package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import dto.internal.FireDTO;
import dto.internal.OperationDTO;
import dto.internal.RideDTO;

@Service
public class SocketService {

	@Autowired
	private SimpMessageSendingOperations socketTemplate;

	public void sendNewFire(FireDTO fire) {
		socketTemplate.convertAndSend("/newFire", fire);
	}
	
	public void updateFire(FireDTO fire) {
		socketTemplate.convertAndSend("/updateFire", fire);
	}
	
	public void sendOperation(OperationDTO operation) {
		socketTemplate.convertAndSend("/operation", operation);
	}
	
	public void sendRide(RideDTO ride) {
		socketTemplate.convertAndSend("/ride", ride);
	}
	
}
