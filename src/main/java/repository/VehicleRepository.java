package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dto.FireDTO;
import dto.VehicleDTO;

@Repository
public interface VehicleRepository extends MongoRepository<VehicleDTO, String> {

}
