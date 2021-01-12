package dto.internal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("FireFighter")
public class FireFighterDTO {

	@Id
	public String id;
	
	public String idFireStation;
	
	public String name;
	
	public FireFighterDTO() {}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getIdFireStation() {
		return idFireStation;
	}
	
	public void setIdFireStation(String idFireStation) {
		this.idFireStation = idFireStation;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
