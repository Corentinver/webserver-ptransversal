package repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dto.internal.RideDTO;

@Repository
public interface RideRepository extends MongoRepository<RideDTO, String> {
	

}
