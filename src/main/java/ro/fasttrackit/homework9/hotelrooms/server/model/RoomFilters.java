package ro.fasttrackit.homework9.hotelrooms.server.model;

import lombok.Value;

@Value
public class RoomFilters {
    String number;
    Integer floor;
    String hotelName;
    Boolean tv;
    Boolean doubleBed;
}
