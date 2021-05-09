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
public class Review {
    @Id
    private String id;

    private String message;
    private int rating;
    private String touristName;

    private String roomId;

    public Review(String message, int rating, String touristName, String roomId) {
        this.message = message;
        this.rating = rating;
        this.touristName = touristName;
        this.roomId = roomId;
    }
}
