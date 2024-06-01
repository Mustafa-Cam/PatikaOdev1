package com.patika.odev2mustafacam.controller;


import com.patika.odev2mustafacam.dto.request.CategorySaveRequest;
import com.patika.odev2mustafacam.dto.request.ProductSaveRequest;
import com.patika.odev2mustafacam.dto.response.CategoryResponse;
import com.patika.odev2mustafacam.dto.response.GenericResponse;
import com.patika.odev2mustafacam.dto.response.ProductResponse;
import com.patika.odev2mustafacam.model.Category;
import com.patika.odev2mustafacam.service.CategoryService;
import com.patika.odev2mustafacam.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor

public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CategorySaveRequest request) {
        categoryService.createCategory(request);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public GenericResponse<List<Category>> getAll() {
        return GenericResponse.success(categoryService.getAllCategories());
    }

}
