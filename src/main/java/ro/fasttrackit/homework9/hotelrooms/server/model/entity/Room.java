package ro.fasttrackit.homework9.hotelrooms.server.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    private String id;

    private String roomNumber;
    private int floor;
    private String hotelName;

    private String roomFacilityId;

    public Room(String roomNumber, int floor, String hotelName, String roomFacilityId) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.hotelName = hotelName;
        this.roomFacilityId = roomFacilityId;
    }
}
