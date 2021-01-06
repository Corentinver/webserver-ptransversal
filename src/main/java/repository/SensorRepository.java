package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dto.SensorDTO;

@Repository
public interface SensorRepository extends MongoRepository<SensorDTO, String> {

}
