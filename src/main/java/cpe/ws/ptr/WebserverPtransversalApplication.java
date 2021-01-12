package cpe.ws.ptr;

import java.util.HashMap;
import java.util.Map;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import dto.internal.FireDTO;
import dto.internal.PointDTO;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = {"repository","controller", "config", "service"})
@EnableMongoRepositories ("repository") 
public class WebserverPtransversalApplication {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	
	public static void main(String[] args) {
		SpringApplication.run(WebserverPtransversalApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner websocketDemo() {
		return (args) -> {
			
			while (true) {
				try {
					Thread.sleep(15000);
					FireDTO fire = new FireDTO();
					fire.setId("fire1");
					fire.setIntensity(80);
					fire.setLocation(new PointDTO(45.8027129, 4.7923363));
					messagingTemplate.convertAndSend("/newFire", fire);
					System.out.println("Envoi");
					Thread.sleep(10000);
					fire.setIntensity(10);
					messagingTemplate.convertAndSend("/updateFire", fire);
					System.out.println("Update");
					Thread.sleep(10000);
					fire.setIntensity(0);
					messagingTemplate.convertAndSend("/updateFire", fire);
					System.out.println("Update");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		};
	}
}