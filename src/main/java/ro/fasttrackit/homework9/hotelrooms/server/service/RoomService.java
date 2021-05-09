package ro.fasttrackit.homework9.hotelrooms.server.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ro.fasttrackit.homework9.hotelrooms.server.exception.ResourceNotFoundException;
import ro.fasttrackit.homework9.hotelrooms.server.model.RoomFilters;
import ro.fasttrackit.homework9.hotelrooms.server.model.entity.Room;
import ro.fasttrackit.homework9.hotelrooms.server.repository.RoomRepository;
import ro.fasttrackit.homework9.hotelrooms.server.repository.dao.RoomDao;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomDao dao;
    private final RoomRepository repository;
    private final ObjectMapper mapper;

    public Page<Room> getAll() {
        return dao.findRooms();
    }

    public Optional<Room> getRoom(String roomId) {
        return repository.findById(roomId);
    }

    public Room deleteRoom(String roomId) {
        var roomToDelete = getOrThrow(roomId);
        repository.deleteById(roomId);

        return roomToDelete;
    }

    private Room getOrThrow(String roomId) {
        return repository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find room with ID: " + roomId));
    }

    @SneakyThrows
    public Room patchRoom(String roomId, JsonPatch patch) {
        Room roomToPatch = getOrThrow(roomId);
        JsonNode patchedRoomJson = patch.apply(mapper.valueToTree(roomToPatch));
        Room patchedRoom = mapper.treeToValue(patchedRoomJson, Room.class);
        return replaceRoom(roomId, patchedRoom);
    }

    private Room replaceRoom(String roomId, Room newRoom) {
        newRoom.setId(roomId);
        Room roomToUpdate = getOrThrow(roomId);
        copyRoom(newRoom, roomToUpdate);
        return repository.save(roomToUpdate);
    }

    private void copyRoom(Room newRoom, Room dbRoom) {
        dbRoom.setRoomFacilityId(newRoom.getRoomFacilityId());
        dbRoom.setFloor(newRoom.getFloor());
        dbRoom.setHotelName(newRoom.getHotelName());
        dbRoom.setRoomNumber(newRoom.getRoomNumber());
    }
}
