package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dto.FireDTO;

@Repository
public interface FireRepository extends MongoRepository<FireDTO, String> {
	
	public FireDTO findByIntensity(double intensity);

}
