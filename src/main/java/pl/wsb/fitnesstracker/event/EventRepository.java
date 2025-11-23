package pl.wsb.fitnesstracker.event;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Event> znajdzEventPoNazwie(String szukanaNazwa) {

        String jpql = "SELECT e FROM Event e WHERE e.name = :nameParam";

        TypedQuery<Event> query = entityManager.createQuery(jpql, Event.class);

        query.setParameter("nameParam", szukanaNazwa);


        return query.getResultList();
    }
}