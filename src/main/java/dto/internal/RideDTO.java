package dto.internal;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Ride")
public class RideDTO {

	@Id
	public String operationId;
	
	public String vehicleId;
	public List<PointDTO> listLocalisations;
	public double duration;
	
	public RideDTO() {}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public List<PointDTO> getListLocalisations() {
		return listLocalisations;
	}

	public void setListLocalisations(List<PointDTO> listLocalisations) {
		this.listLocalisations = listLocalisations;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}
	
}
