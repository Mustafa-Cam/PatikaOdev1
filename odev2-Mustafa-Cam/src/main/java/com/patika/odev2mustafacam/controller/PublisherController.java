package com.patika.odev2mustafacam.controller;

import com.patika.odev2mustafacam.dto.request.PublisherSaveRequest;
import com.patika.odev2mustafacam.dto.response.GenericResponse;
import com.patika.odev2mustafacam.model.Publisher;
import com.patika.odev2mustafacam.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody PublisherSaveRequest request) {
        publisherService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public GenericResponse<List<Publisher>> getAll() {
        return GenericResponse.success(publisherService.getAllPublishers());
    }


}
