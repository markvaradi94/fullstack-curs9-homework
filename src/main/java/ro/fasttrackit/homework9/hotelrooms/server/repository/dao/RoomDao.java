package ro.fasttrackit.homework9.hotelrooms.server.repository.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.homework9.hotelrooms.server.model.RoomFilters;
import ro.fasttrackit.homework9.hotelrooms.server.model.entity.Room;
import ro.fasttrackit.homework9.hotelrooms.server.model.entity.RoomFacilities;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

@Repository
@RequiredArgsConstructor
public class RoomDao {
    private final MongoTemplate mongo;

    public Page<Room> findRooms() {
        Criteria criteria = Criteria.where("roomNumber").regex(".*A.*");

        Query query = Query.query(criteria);
        PageRequest pageable = PageRequest.of(0, 2, Sort.by("roomNumber"));
        query.with(pageable);
        List<Room> rooms = mongo.find(
                query,
                Room.class);
        return PageableExecutionUtils.getPage(
                rooms,
                pageable,
                () -> mongo.count(Query.query(criteria), Room.class));
    }

//    public RoomDao(EntityManager entityManager) {
//        this.entityManager = entityManager;
//        criteriaBuilder = this.entityManager.getCriteriaBuilder();
//    }
//
//    public List<Room> getAll(RoomFilters filters) {
//        CriteriaQuery<Room> criteria = criteriaBuilder.createQuery(Room.class);
//
//        Root<Room> roomRoot = criteria.from(Room.class);
//        Join<Room, RoomFacilities> facilitiesRoot = roomRoot.join("roomFacilities");
//
//        CriteriaQuery<Room> query = criteria.select(roomRoot)
//                .where(getWhereClause(filters, roomRoot, facilitiesRoot).toArray(new Predicate[0]));
//
//        return entityManager.createQuery(query).getResultList();
//    }
//
//    private List<Predicate> getWhereClause(RoomFilters filters, Root<Room> roomRoot,
//                                           Join<Room, RoomFacilities> facilitiesRoot) {
//        List<Predicate> whereClause = new ArrayList<>();
//
//        ofNullable(filters.getHotelName())
//                .ifPresent(hotelName -> whereClause.add(criteriaBuilder.equal(roomRoot.get("hotelName"), hotelName)));
//        ofNullable(filters.getFloor())
//                .ifPresent(floor -> whereClause.add(criteriaBuilder.equal(roomRoot.get("floor"), floor)));
//        ofNullable(filters.getNumber())
//                .ifPresent(number -> whereClause.add(criteriaBuilder.equal(roomRoot.get("number"), number)));
//        ofNullable(filters.getTv())
//                .ifPresent(tv -> whereClause.add(criteriaBuilder.equal(facilitiesRoot.get("tv"), tv)));
//        ofNullable(filters.getDoubleBed())
//                .ifPresent(doubleBed -> whereClause.add(criteriaBuilder.equal(facilitiesRoot.get("doubleBed"),
//                        doubleBed)));
//
//        return whereClause;
//    }
}
