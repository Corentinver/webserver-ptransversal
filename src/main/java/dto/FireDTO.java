package dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Fire")
public class FireDTO {

	@Id
	public String id;
	public double intensity;
	public int typeFire;
	public PointDTO location;
	
	public FireDTO() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getIntensity() {
		return intensity;
	}

	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}

	public int getTypeFire() {
		return typeFire;
	}

	public void setTypeFire(int typeFire) {
		this.typeFire = typeFire;
	}

	public PointDTO getLocation() {
		return location;
	}

	public void setLocation(PointDTO location) {
		this.location = location;
	}
	
}
