package com.patika.odev2mustafacam.repository;

import com.patika.odev2mustafacam.model.Category;
import com.patika.odev2mustafacam.model.Publisher;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.*;

@Getter
@Repository
public class CategoryRepository {

    private  List<Category> categoryList = new ArrayList<>();

    public void createCategory(Category category) {
        categoryList.add(category);
    }

    public List<Category> findAll() {
        return categoryList;
    }

}
