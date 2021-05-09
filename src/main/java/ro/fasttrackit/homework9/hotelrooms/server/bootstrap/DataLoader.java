package ro.fasttrackit.homework9.hotelrooms.server.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fasttrackit.homework9.hotelrooms.server.model.entity.*;
import ro.fasttrackit.homework9.hotelrooms.server.repository.CleaningProcedureRepository;
import ro.fasttrackit.homework9.hotelrooms.server.repository.CleanupRepository;
import ro.fasttrackit.homework9.hotelrooms.server.repository.ReviewRepository;
import ro.fasttrackit.homework9.hotelrooms.server.repository.RoomRepository;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final RoomRepository roomRepository;
    private final ReviewRepository reviewRepository;
    private final CleaningProcedureRepository cleaningProcedureRepository;
    private final CleanupRepository cleanupRepository;

    @Override
    public void run(String... args) throws Exception {
        final var roomFacilities = List.of(
                new RoomFacilities(true, true),
                new RoomFacilities(true, false),
                new RoomFacilities(false, false),
                new RoomFacilities(false, true)
        );

        final var rooms = List.of(
                new Room("101", 1, "Hungarian Paradise", roomFacilities.get(0).getId()),
                new Room("369", 3, "Hungarian Paradise", roomFacilities.get(1).getId()),
                new Room("420", 4, "Hungarian Bliss", roomFacilities.get(3).getId())
        );
        roomRepository.saveAll(rooms);

        final var cleanups = List.of(
                new Cleanup(LocalDate.now().minusDays(1), rooms.get(0).getId()),
                new Cleanup(LocalDate.now().minusDays(10), rooms.get(2).getId()),
                new Cleanup(LocalDate.now().minusDays(2), rooms.get(1).getId())
        );

        cleanupRepository.saveAll(cleanups);

        final var cleaningProcedures = List.of(
                new CleaningProcedure("Change sheets", 1, cleanups.get(0).getId()),
                new CleaningProcedure("Change towels", 0, cleanups.get(1).getId()),
                new CleaningProcedure("Vacuum", 1, cleanups.get(2).getId())
        );

        cleaningProcedureRepository.saveAll(cleaningProcedures);

        final var reviews = List.of(
                new Review("Coolest", 5, "Csongi", rooms.get(0).getId()),
                new Review("Meh", 3, "Attila", rooms.get(2).getId()),
                new Review("Like in Romania", 1, "Hunor", rooms.get(1).getId())
        );
        reviewRepository.saveAll(reviews);

        roomRepository.findAll().forEach(System.out::println);
    }

}
