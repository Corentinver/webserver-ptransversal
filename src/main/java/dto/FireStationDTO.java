package dto;

import java.awt.Point;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("FireStation")
public class FireStationDTO {
	
	@Id
	public int id;
	
	public PointDTO location;
	
	public String name;
	
	public FireStationDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PointDTO getLocation() {
		return location;
	}

	public void setLocation(PointDTO location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
