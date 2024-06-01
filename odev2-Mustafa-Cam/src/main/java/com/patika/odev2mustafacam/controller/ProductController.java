package com.patika.odev2mustafacam.controller;

import com.patika.odev2mustafacam.dto.request.ProductSaveRequest;
import com.patika.odev2mustafacam.dto.response.GenericResponse;
import com.patika.odev2mustafacam.dto.response.ProductResponse;
//import com.patika.odev2mustafacam.model.enums.Category;
import com.patika.odev2mustafacam.model.Category;
import com.patika.odev2mustafacam.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ProductSaveRequest request) {
        productService.save(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public GenericResponse<Set<ProductResponse>> getAll() {
        return GenericResponse.success(productService.getAll());
    }


    @GetMapping("/category/{category}")
    public GenericResponse<Set<ProductResponse>> getAllByCategory(@PathVariable String category){
        return GenericResponse.success(productService.getByCategory(category));
    }

     @GetMapping("/publisher/name/{publisherName}")
    public GenericResponse<Set<ProductResponse>> getByPublisherName(@PathVariable String publisherName){
        return GenericResponse.success(productService.getByPublisherName(publisherName));
     }

     @GetMapping("/publisher/id/{publisherID}")
    public GenericResponse<Set<ProductResponse>> getByPublisherName(@PathVariable Long publisherID){
        return GenericResponse.success(productService.getByPublisherID(publisherID));
     }


}
