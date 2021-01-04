package dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("J_TVehicle_TFire")
public class J_TVehicle_TFireDTO {

	public int typeVehicle;
	public int typeFire;
	
	public J_TVehicle_TFireDTO() {}

	public int getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(int typeVehicle) {
		this.typeVehicle = typeVehicle;
	}

	public int getTypeFire() {
		return typeFire;
	}

	public void setTypeFire(int typeFire) {
		this.typeFire = typeFire;
	}

}
