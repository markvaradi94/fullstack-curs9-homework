package ro.fasttrackit.homework9.hotelrooms.server.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.homework9.hotelrooms.server.model.entity.Review;
import ro.fasttrackit.homework9.hotelrooms.server.repository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository repository;

    public List<Review> getRoomReviews(String roomId) {
        return repository.findAllByRoomId(roomId);
    }
}
