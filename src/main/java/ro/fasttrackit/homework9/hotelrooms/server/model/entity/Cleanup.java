package ro.fasttrackit.homework9.hotelrooms.server.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Builder
@Document(collection = "cleanups")
@NoArgsConstructor
@AllArgsConstructor
public class Cleanup {
    @Id
    private String id;

    private LocalDate date;

    private String roomId;

    public Cleanup(LocalDate date, String roomId) {
        this.date = date;
        this.roomId = roomId;
    }
}
