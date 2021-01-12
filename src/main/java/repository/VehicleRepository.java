package repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dto.internal.VehicleDTO;

@Repository
public interface VehicleRepository extends MongoRepository<VehicleDTO, String> {

	public List<VehicleDTO> findByIdFireStation(ObjectId idFireStation);

	
}
