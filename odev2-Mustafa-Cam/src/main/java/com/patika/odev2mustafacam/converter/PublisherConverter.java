package com.patika.odev2mustafacam.converter;

import com.patika.odev2mustafacam.dto.request.PublisherSaveRequest;
import com.patika.odev2mustafacam.model.Publisher;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PublisherConverter {

    public static Publisher toPublisher(PublisherSaveRequest request) {
        return Publisher.builder()
                .id(request.getID())
                .name(request.getName())
                .creatDate(request.getCreateDate())
                .build();
    }
}