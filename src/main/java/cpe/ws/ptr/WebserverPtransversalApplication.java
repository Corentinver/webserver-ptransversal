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
			/*
			while (true) {
				try {
					Thread.sleep(3*1000); // Each 3 sec.
					messagingTemplate.convertAndSend("/newFire", new FireDTO());
					messagingTemplate.convertAndSend("/newFire/test", new FireDTO());
					messagingTemplate.convertAndSend("/operation", new FireDTO());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			*/
		};
	}
}