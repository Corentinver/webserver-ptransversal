package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dto.internal.FireDTO;
import dto.internal.VehicleDTO;

@Repository
public interface VehicleRepository extends MongoRepository<VehicleDTO, String> {

}
