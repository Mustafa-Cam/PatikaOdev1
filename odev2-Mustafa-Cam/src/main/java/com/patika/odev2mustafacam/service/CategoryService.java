package com.patika.odev2mustafacam.service;

import com.patika.odev2mustafacam.converter.CategoryConverter;
import com.patika.odev2mustafacam.dto.request.CategorySaveRequest;
import com.patika.odev2mustafacam.dto.response.CategoryResponse;
import com.patika.odev2mustafacam.model.Category;
import com.patika.odev2mustafacam.model.Publisher;
import com.patika.odev2mustafacam.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;



    public void createCategory(CategorySaveRequest request) {

        Category category = CategoryConverter.toCategory(request);

        categoryRepository.createCategory(category);

        log.info("Category created : {}", category.toString());
    }

    public List<Category> getAllCategories() {
        log.info("get all publishers.");
        return categoryRepository.findAll();
    }

    public Optional<Category> getByName(String categoryName) {
        return getAllCategories().stream()
                .filter(category -> category.getCategoryName().equals(categoryName))
                .findFirst();
    }
}
