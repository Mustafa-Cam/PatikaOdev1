package com.patika.odev2mustafacam.converter;

import com.patika.odev2mustafacam.dto.request.CategorySaveRequest;
import com.patika.odev2mustafacam.dto.request.ProductSaveRequest;
import com.patika.odev2mustafacam.dto.response.ProductResponse;
import com.patika.odev2mustafacam.model.Category;
import com.patika.odev2mustafacam.model.Product;
import com.patika.odev2mustafacam.model.Publisher;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE) // nesne oluşturulmasın diye.
public class ProductConverter {

    public static Product toProduct(ProductSaveRequest request, Publisher publisher, Category category) {

        return Product.builder()
                .name(request.getName())
                .amount(request.getAmount())
                .description(request.getDescription())
                .publisher(publisher)
                .category(category)
                .build();
    }

    public static ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .amount(product.getAmount())
                .name(product.getName())
                .description(product.getDescription())
                .publisherName(product.getPublisher().getName())
                .category(product.getCategory().getCategoryName())
                .build();
    }
    public static Product toProductResponse(Product product2) {
        return Product.builder()
                .amount(product2.getAmount())
                .name(product2.getName())
                .description(product2.getDescription())
                .publisher(product2.getPublisher())
                .category(product2.getCategory())
                .build();
    }

    public static Set<ProductResponse> toResponse(Set<Product> products) {
        return products
                .stream()
                .map(ProductConverter::toResponse)
                .collect(Collectors.toSet());
    }
    public static List<Product> toResponse(List<Product> products) {
        return products
                .stream()
                .map(ProductConverter::toProductResponse)
                .collect(Collectors.toList());
    }


}
