package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dto.internal.FireFighterDTO;

@Repository
public interface FireFighterRepository extends MongoRepository<FireFighterDTO, String> {

}
