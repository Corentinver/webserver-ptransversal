package dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("FireFighter")
public class FireFighterDTO {

	@Id
	public int id;
	
	public int idFireStation;
	
	public String name;
	
	public FireFighterDTO() {}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdFireStation() {
		return idFireStation;
	}
	
	public void setIdFireStation(int idFireStation) {
		this.idFireStation = idFireStation;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
