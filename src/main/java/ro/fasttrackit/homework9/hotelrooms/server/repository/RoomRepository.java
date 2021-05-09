package ro.fasttrackit.homework9.hotelrooms.server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.homework9.hotelrooms.server.model.entity.Room;

public interface RoomRepository extends MongoRepository<Room, String> {
}
