package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dto.FireStationDTO;
import dto.FireFighterDTO;
import dto.VehicleDTO;
import repository.FireFighterRepository;
import repository.FireRepository;
import repository.FireStationRepository;
import repository.SensorRepository;
import repository.VehicleRepository;
import dto.SensorDTO;

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
}
