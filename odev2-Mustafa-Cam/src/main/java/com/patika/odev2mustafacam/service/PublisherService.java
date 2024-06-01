package com.patika.odev2mustafacam.service;

import com.patika.odev2mustafacam.converter.PublisherConverter;
import com.patika.odev2mustafacam.dto.request.PublisherSaveRequest;
import com.patika.odev2mustafacam.exception.ExceptionMessages;
import com.patika.odev2mustafacam.exception.KitapYurdumException;
import com.patika.odev2mustafacam.model.Publisher;
import com.patika.odev2mustafacam.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public void save(PublisherSaveRequest request) {

        Publisher publisher = PublisherConverter.toPublisher(request);

          Publisher ispublisher = publisherRepository.findByName(request.getName());
          if (ispublisher != null) {
              log.error(ExceptionMessages.PUBLISHERNAME_ALREADY_EXIST);
              throw new KitapYurdumException(ExceptionMessages.PUBLISHERNAME_ALREADY_EXIST);

          }
        publisherRepository.save(publisher);

        log.info("publisher saved. {}", publisher.toString());
    }

    public List<Publisher> getAllPublishers() {
        log.info("get all publishers.");
        return publisherRepository.findAll();
    }

    public Optional<Publisher> getByName(String publisherName) {
        return getAllPublishers().stream()
                .filter(publisher -> publisher.getName().equals(publisherName))
                .findFirst();
    }
}
