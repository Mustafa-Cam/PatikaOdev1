package com.patika.odev2mustafacam.converter;


import com.patika.odev2mustafacam.dto.request.CategorySaveRequest;
import com.patika.odev2mustafacam.dto.request.ProductSaveRequest;
import com.patika.odev2mustafacam.dto.response.CategoryResponse;
import com.patika.odev2mustafacam.dto.response.ProductResponse;
import com.patika.odev2mustafacam.model.Category;
import com.patika.odev2mustafacam.model.Product;
import com.patika.odev2mustafacam.model.Publisher;
//import com.patika.odev2mustafacam.model.enums.Category;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE) // nesne oluşturulmasın diye.
public class CategoryConverter {

    public static Category toCategory(CategorySaveRequest request) {
        return Category.builder()
                .categoryName(request.getCategoryName())
                .build();
    }

    public static CategoryResponse toResponse(Category category) {
        return CategoryResponse.builder()
                .CategoryName(category)
                .build();
    }

    public static Set<CategoryResponse> toResponse(Set<Category> categories) {
        return categories
                .stream()
                .map(CategoryConverter::toResponse)
                .collect(Collectors.toSet());
    }

}
