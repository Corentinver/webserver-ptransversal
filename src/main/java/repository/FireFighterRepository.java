package repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dto.internal.FireFighterDTO;

@Repository
public interface FireFighterRepository extends MongoRepository<FireFighterDTO, String> {
	
	
	List<FireFighterDTO> findByName(String name);
	
	List<FireFighterDTO> findByIdFireStation(ObjectId idFireStation);
	


}
