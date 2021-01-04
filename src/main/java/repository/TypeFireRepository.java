package repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import dto.FireDTO;

public interface TypeFireRepository extends MongoRepository<FireDTO, String> {

}
