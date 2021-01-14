package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.assertj.core.util.Arrays;
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

    public PointDTO getPointDTOByVehicle(String idVehicle){
        Optional<VehicleDTO> ve = vehicleRepository.findById(new ObjectId(idVehicle));
        PointDTO point = null;
        if(ve.isPresent()){
            point = fireStationRepository.findById(new ObjectId(ve.get().idFireStation)).get().location;

        }
        return point;
    }
    
    public FireStationInfosDTO getFireStationInfos(String idFireStation) {
    	List<FireFighterDTO> fireFighters = fireFighterRepository.findByIdFireStation(new ObjectId(idFireStation));
    	List<VehicleDTO> listVehicles = vehicleRepository.findByIdFireStation(new ObjectId(idFireStation));
    	FireStationInfosDTO fireStationInfos = new FireStationInfosDTO();
    	fireStationInfos.setNbFireFighters(fireFighters.size());
    	fireStationInfos.buildVehiclesByType(listVehicles);
    	return fireStationInfos;  	
    }

    public FireStationResourcesDTO getFireStationResourcesAvailable(String idFireStation){
        List<FireFighterDTO> fireFighters = fireFighterRepository.findByIdFireStation(new ObjectId(idFireStation));
        List<VehicleDTO> listVehicles = vehicleRepository.findByIdFireStation(new ObjectId(idFireStation));
        List<FireDTO> listFires = fireRepository.findByState(FireDTO.stateFire.InOperation.toString());
        List<String> idFires = new ArrayList<String>();
        listFires.forEach(fire -> idFires.add(fire.id));

        Iterable<OperationDTO> listOperation = operationRepository.findAllByIdFire((Iterable<String>)idFires);
        List<String> idVehicleToRemove = new ArrayList<String>();
        List<String> idFireFighterToRemove = new ArrayList<String>();
        for(OperationDTO operationDTO : listOperation){
            for(String id : operationDTO.idVehicle){
                if(!idVehicleToRemove.contains(id)){
                    idVehicleToRemove.add(id);
                }
            }

            for(String id : operationDTO.idFireFighter){
                if(!idFireFighterToRemove.contains(id)){
                    idFireFighterToRemove.add(id);
                }
            }
        }
        List<VehicleDTO> listVehiclesToReturn = new ArrayList<VehicleDTO>();
        List<String> listFireFighterToReturn = new ArrayList<String>();

        listVehicles.forEach(vehicle -> {
            if(!idVehicleToRemove.contains(vehicle.id)){
                listVehiclesToReturn.add(vehicle);
            }
        });

        fireFighters.forEach(fireFighter -> {
            if(!idFireFighterToRemove.contains(fireFighter.id)){
                listFireFighterToReturn.add(fireFighter.id);
            }
        });


        FireStationResourcesDTO fireStationResources = new FireStationResourcesDTO();
        fireStationResources.setId(idFireStation);
    	fireStationResources.setIdFireFighters(listFireFighterToReturn);
        fireStationResources.setVehicles(listVehiclesToReturn);
        
        System.out.println("Fire station id :" + idFireStation);
        System.out.println("List : " + listFireFighterToReturn);
    	return fireStationResources;
    }

    /**
     * 
     * Si j'ai le temps
     * Optimisation du code
     * List<VehicleDTO> filterVehicle = vehicles.stream().filter(ve -> (station.get().id.equals(ve.idFireStation))).collect(Collectors.toList());
                List<FireFighterDTO> filterFireFighter = fireFighters.stream().filter(fe -> (station.get().id.equals(fe.idFireStation))).collect(Collectors.toList());
     */
}
