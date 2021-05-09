package ro.fasttrackit.homework9.hotelrooms.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.homework9.hotelrooms.server.model.entity.Cleanup;

public interface CleanupRepository extends MongoRepository<Cleanup, String> {
}
