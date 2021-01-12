package repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dto.internal.FireStationDTO;

@Repository
public interface FireStationRepository extends MongoRepository<FireStationDTO, String> {

	public Optional<FireStationDTO> findById(ObjectId id);
	
}
