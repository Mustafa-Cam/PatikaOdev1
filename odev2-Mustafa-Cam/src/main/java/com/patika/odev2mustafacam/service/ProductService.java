package com.patika.odev2mustafacam.service;

import com.patika.odev2mustafacam.converter.ProductConverter;
import com.patika.odev2mustafacam.dto.request.ProductSaveRequest;
import com.patika.odev2mustafacam.dto.response.ProductResponse;
import com.patika.odev2mustafacam.model.Product;
import com.patika.odev2mustafacam.model.Publisher;
//import com.patika.odev2mustafacam.model.enums.Category;
import com.patika.odev2mustafacam.model.Category;
import com.patika.odev2mustafacam.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final PublisherService publisherService;
    private final CategoryService categoryService;

    public void save(ProductSaveRequest request) {

        Optional<Publisher> optionalPublisher = publisherService.getByName(request.getPublisherName());
        Optional<Category> optionalCategory = categoryService.getByName(request.getCategoryName());

        if (optionalPublisher.isEmpty()) {
            log.error("publisher bulamadım : {}", request.getPublisherName());
            throw new RuntimeException("publisher bulamadım");
        }
        if (optionalCategory.isEmpty()) {
            log.error("category yok:{}",request.getCategoryName());
            throw new RuntimeException("category yok");
        }

        Product product = ProductConverter.toProduct(request, optionalPublisher.get(),optionalCategory.get());

        productRepository.save(product);

        log.info("product created : {}", product.toString());
    }

    public Set<ProductResponse> getAll() {
        return ProductConverter.toResponse(productRepository.getAll());
    }

    public Set<ProductResponse> getByCategory(String category) {
        return ProductConverter.toResponse(productRepository.getByCategory(category));
    }

    public Set<ProductResponse> getByPublisherName(String publisherName) {
        return ProductConverter.toResponse(productRepository.getByPublisherName(publisherName));

    }

    public Set<ProductResponse> getByPublisherID(Long publisherID) {
        return ProductConverter.toResponse(productRepository.getByPublisherID(publisherID));
    }

    public List<Product> getProductListByNames(List<String> productNames) {
        return  ProductConverter.toResponse(productRepository.getProductsByNames(productNames));
    }
}
