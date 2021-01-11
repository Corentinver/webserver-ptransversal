package dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Vehicle")
public class VehicleDTO {

	@Id
	public String id;
	
	public String idType;
	
	public String idFireStation;
	
	public VehicleDTO() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdFireStation() {
		return idFireStation;
	}

	public void setIdFireStation(String idFireStation) {
		this.idFireStation = idFireStation;
	}
	
}
