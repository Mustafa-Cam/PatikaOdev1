package com.patika.odev2mustafacam.dto.request;

import com.patika.odev2mustafacam.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaveRequest {
    private String name;
    private BigDecimal amount;
    private String description;
    private String publisherName;
    private String categoryName;
}
