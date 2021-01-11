package dto.internal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("TypeVehicle")
public class TypeVehicleDTO {

	@Id
	public String id;
	
	public String name;
	
	public int idFireStation;
	
	public TypeVehicleDTO() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdFireStation() {
		return idFireStation;
	}

	public void setIdFireStation(int idFireStation) {
		this.idFireStation = idFireStation;
	}
	
}
