package repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dto.internal.OperationDTO;

@Repository
public interface OperationRepository extends MongoRepository<OperationDTO, String> {
    
    public List<OperationDTO> findAllByIdFire(Iterable<String> idFire);
}
