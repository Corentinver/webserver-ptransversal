package repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dto.internal.FireDTO;

@Repository
public interface FireRepository extends MongoRepository<FireDTO, String> {
	
	public FireDTO findByIntensity(double intensity);

	public List<FireDTO> findByState(String state);

}
