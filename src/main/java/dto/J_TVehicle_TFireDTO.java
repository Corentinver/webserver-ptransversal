package dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("J_TVehicle_TFire")
public class J_TVehicle_TFireDTO {

	public String typeVehicle;
	public String typeFire;
	
	public J_TVehicle_TFireDTO() {}

	public String getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}

	public String getTypeFire() {
		return typeFire;
	}

	public void setTypeFire(String typeFire) {
		this.typeFire = typeFire;
	}

}
