package com.patika.odev2mustafacam.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRequest {
    private String author;
    private String name;
    private BigDecimal amount;
    private String description;
    private String publisher;

}
