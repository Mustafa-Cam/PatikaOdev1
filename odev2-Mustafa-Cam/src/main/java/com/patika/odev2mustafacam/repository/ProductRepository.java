package com.patika.odev2mustafacam.repository;

import com.patika.odev2mustafacam.model.Product;
//import com.patika.odev2mustafacam.model.enums.Category;
import com.patika.odev2mustafacam.model.Category;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private Set<Product> productSet = new HashSet<>();

    public void save(Product product) {
        productSet.add(product);
    }

    public Set<Product> getAll() {
        return productSet;
    }

    public Set<Product> getByCategory(String category) {
        return productSet.stream()
                .filter(p-> p.getCategory().getCategoryName().equals(category))
                .collect(Collectors.toSet());
    }

    public Set<Product> getByPublisherName(String publisherName) {
        return productSet.stream()
                .filter(pn->pn.getPublisher().getName().equals(publisherName))
                .collect(Collectors.toSet());


    }

    public Set<Product> getByPublisherID(Long publisherID) {
        return productSet.stream().filter(pid-> Objects.equals(pid.getPublisher().getId(), publisherID)).collect(Collectors.toSet());
    }

    public List<Product> getProductsByNames(List<String> names) {
        return productSet.stream()
                .filter(product -> names.contains(product.getName()))
                .collect(Collectors.toList());
    }
}
