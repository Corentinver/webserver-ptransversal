package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dto.internal.TypeVehicleDTO;

@Repository
public interface TypeVehicleRepository extends MongoRepository<TypeVehicleDTO, String> {

}
