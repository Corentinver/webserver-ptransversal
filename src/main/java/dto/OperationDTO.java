package dto;

import java.awt.Point;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Operation")
public class OperationDTO {

	@Id
	public int id;
	
	public List<Integer> idFireFighter;
	
	public List<Integer> idVehicle;
	
	public int idFire;
	
	public PointDTO location;
	
	public OperationDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Integer> getIdFireFighter() {
		return idFireFighter;
	}

	public void setIdFireFighter(List<Integer> idFireFighter) {
		this.idFireFighter = idFireFighter;
	}

	public List<Integer> getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(List<Integer> idVehicle) {
		this.idVehicle = idVehicle;
	}

	public int getIdFire() {
		return idFire;
	}

	public void setIdFire(int idFire) {
		this.idFire = idFire;
	}

	public PointDTO getLocation() {
		return location;
	}

	public void setLocation(PointDTO location) {
		this.location = location;
	}
	
}
