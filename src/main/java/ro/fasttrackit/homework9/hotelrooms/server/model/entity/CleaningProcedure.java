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
public class CleaningProcedure {
    @Id
    private String id;

    private String name;
    private int outcome;

    private String cleanupId;

    public CleaningProcedure(String name, int outcome, String cleanupId) {
        this.name = name;
        this.outcome = outcome;
        this.cleanupId = cleanupId;
    }
}
