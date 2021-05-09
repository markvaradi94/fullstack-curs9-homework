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
public class RoomFacilities {
    @Id
    private String id;

    private boolean tv;
    private boolean doubleBed;

    public RoomFacilities(boolean tv, boolean doubleBed) {
        this.tv = tv;
        this.doubleBed = doubleBed;
    }
}
