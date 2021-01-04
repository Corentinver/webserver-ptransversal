package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dto.J_TVehicle_TFireDTO;

@Repository
public interface J_TVehicle_TFireRepository extends MongoRepository<J_TVehicle_TFireDTO, String> {

}
