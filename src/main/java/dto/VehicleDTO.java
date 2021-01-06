package dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Vehicle")
public class VehicleDTO {

	@Id
	public String id;
	
	public int idType;
	
	public int idFireStation;
	
	public VehicleDTO() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
