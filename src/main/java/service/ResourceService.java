package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.internal.FireFighterDTO;
import dto.internal.FireStationDTO;
import dto.internal.SensorDTO;
import dto.internal.VehicleDTO;
import repository.FireFighterRepository;
import repository.FireRepository;
import repository.FireStationRepository;
import repository.J_TVehicle_TFireRepository;
import repository.OperationRepository;
import repository.SensorRepository;
import repository.TypeFireRepository;
import repository.TypeVehicleRepository;
import repository.VehicleRepository;
import dto.internal.*;

@Service
public class ResourceService {
    @Autowired
	public FireRepository fireRepository;
	
	@Autowired
	public FireStationRepository fireStationRepository;

	@Autowired
	public FireFighterRepository fireFighterRepository;

	@Autowired
	public VehicleRepository vehicleRepository;

	@Autowired
    public SensorRepository sensorRepository;

    @Autowired
    public TypeFireRepository typeFireRepository;

    @Autowired
    public TypeVehicleRepository typeVehicleRepository;

    @Autowired
    public OperationRepository operationRepository;

    @Autowired
    public J_TVehicle_TFireRepository j_TVehicle_TFireRepository;
    
    public List<FireStationDTO> getAllFireStation()
    {
        return fireStationRepository.findAll();
    }

    public List<FireFighterDTO> getAllFireFighter()
    {
        return fireFighterRepository.findAll();
    }

    public List<VehicleDTO> getAllVehicle()
    {
        return vehicleRepository.findAll();
    }
    
    public List<SensorDTO> getAllSensor()
    {
        return sensorRepository.findAll();
    }

    public List<TypeFireDTO> getAllTypeFire()
    {
        return typeFireRepository.findAll();
    }

    
    public List<J_TVehicle_TFireDTO> getAllTVehicle_TFire()
    {
        return j_TVehicle_TFireRepository.findAll();
    }

    /*
    public List<TypeVehicleRepository> getAllSensor()
    {
        return sensorRepository.findAll();
    }

    /*
    public List<OperationRepository> getAllSensor()
    {
        return operationRepository.findAll();
    }
    */
    
    public List<TypeVehicleDTO> getAllTypeVehicle() {
    	return typeVehicleRepository.findAll();
    }
    
    public FireStationInfosDTO getFireStationInfos(String idFireStation) {
    	List<FireFighterDTO> fireFighters = fireFighterRepository.findByIdFireStation(new ObjectId(idFireStation));
    	List<VehicleDTO> listVehicles = vehicleRepository.findByIdFireStation(new ObjectId(idFireStation));
    	FireStationInfosDTO fireStationInfos = new FireStationInfosDTO();
    	fireStationInfos.setNbFireFighters(fireFighters.size());
    	fireStationInfos.buildVehiclesByType(listVehicles);
    	return fireStationInfos;  	
    }
}
