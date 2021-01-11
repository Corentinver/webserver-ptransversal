package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.internal.FireDTO;

@Component
public class PasserelleService {

	@Autowired
	public RestTemplate restTemplate;
	
	public void newFire(FireDTO fire) {
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    ObjectMapper objectMapper = new ObjectMapper();
		HttpEntity<String> request;
		try {
			request = new HttpEntity<String>(objectMapper.writeValueAsString(fire), headers);
			restTemplate.postForEntity("http://localhost:8081/newFire", request, FireDTO.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public void updateFire(FireDTO fire) {
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    ObjectMapper objectMapper = new ObjectMapper();
		HttpEntity<String> request;
		try {
			request = new HttpEntity<String>(objectMapper.writeValueAsString(fire), headers);
			restTemplate.postForEntity("http://localhost:8081/updateFire", request, FireDTO.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
}
