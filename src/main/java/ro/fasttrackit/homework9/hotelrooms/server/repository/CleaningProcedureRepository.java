package ro.fasttrackit.homework9.hotelrooms.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.homework9.hotelrooms.server.model.entity.CleaningProcedure;

import java.util.List;

public interface CleaningProcedureRepository extends MongoRepository<CleaningProcedure, String> {
}
