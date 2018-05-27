package com.example.app.Repository;
import com.example.app.entity.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findAll();
}
