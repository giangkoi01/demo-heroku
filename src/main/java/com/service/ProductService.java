package com.service;

import com.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
     List<Product> readAll();
     Product update(Product product);
     Product delete(Integer id);
     Product create(Product product);
     Optional<Product> findById(Integer id);
     Product detail(Integer id);
}
