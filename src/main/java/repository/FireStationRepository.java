package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dto.internal.FireStationDTO;

@Repository
public interface FireStationRepository extends MongoRepository<FireStationDTO, String> {

}
