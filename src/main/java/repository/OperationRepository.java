package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dto.OperationDTO;

@Repository
public interface OperationRepository extends MongoRepository<OperationDTO, String> {

}