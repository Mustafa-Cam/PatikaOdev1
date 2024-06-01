package com.patika.odev2mustafacam.dto.request;

import lombok.Data;

@Data
public class AddressUpdateRequest {
    private String title;
    private String province;
    private String description;
    private String newEmail;
}

