package repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dto.internal.VehicleDTO;

@Repository
public interface VehicleRepository extends MongoRepository<VehicleDTO, String> {

	public Optional<VehicleDTO> findById(ObjectId id);
	
	public List<VehicleDTO> findByIdFireStation(ObjectId idFireStation);
	
	
}
