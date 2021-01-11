package repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import dto.TypeFireDTO;

public interface TypeFireRepository extends MongoRepository<TypeFireDTO, String> {

}
