package com.patika.odev2mustafacam.repository;

import com.patika.odev2mustafacam.model.Publisher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PublisherRepository {

    private List<Publisher> publishers = new ArrayList<>();

    public void save(Publisher publisher) {
        publishers.add(publisher);
    }

    public List<Publisher> findAll() {
        return publishers;
    }

    public Publisher findByName(String name) {
        for (Publisher publisher : publishers) {
            if (publisher.getName().equals(name)) {
                return publisher;
            }
        }
        return null;
    }
}
