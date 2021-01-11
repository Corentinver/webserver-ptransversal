package service;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import dto.internal.FireDTO;
import dto.internal.OperationDTO;

@Service
public class SocketService {

	private SimpMessageSendingOperations socketTemplate;

	public void sendNewFire(FireDTO fire) {
		socketTemplate.convertAndSend("/newFire", fire);
	}
	
	public void updateFire() {
		// socketTemplate.convertAndSend("updateFire", x);
	}
	
	public void sendOperation(OperationDTO operation) {
		socketTemplate.convertAndSend("/operation", operation);
	}
	
	
	
}
