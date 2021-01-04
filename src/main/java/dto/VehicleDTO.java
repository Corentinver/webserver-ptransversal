package dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Vehicle")
public class VehicleDTO {

	@Id
	public int id;
	
	public int idType;
	
	public int idFireStation;
	
	public VehicleDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public int getIdFireStation() {
		return idFireStation;
	}

	public void setIdFireStation(int idFireStation) {
		this.idFireStation = idFireStation;
	}
	
}
