package dto.internal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Sensor")
public class SensorDTO {
    @Id
	public String id;
	
	public PointDTO location;
	
    public String name;
    
    public SensorDTO() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
