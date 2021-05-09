package ro.fasttrackit.homework9.hotelrooms.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.homework9.hotelrooms.server.exception.ResourceNotFoundException;
import ro.fasttrackit.homework9.hotelrooms.server.model.entity.CleaningProcedure;
import ro.fasttrackit.homework9.hotelrooms.server.model.entity.Cleanup;
import ro.fasttrackit.homework9.hotelrooms.server.repository.CleaningProcedureRepository;
import ro.fasttrackit.homework9.hotelrooms.server.repository.CleanupRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CleaningProcedureService {
    private final CleaningProcedureRepository repository;
    private final CleanupRepository cleanupRepository;

    public List<CleaningProcedure> getRoomCleanups(String roomId) {
        return repository.findAll().stream()
                .filter(procedure -> getOrThrow(procedure.getCleanupId()).getRoomId().equalsIgnoreCase(roomId))
                .collect(Collectors.toList());
    }

    private Cleanup getOrThrow(String id) {
        return cleanupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find cleanup"));
    }
}
