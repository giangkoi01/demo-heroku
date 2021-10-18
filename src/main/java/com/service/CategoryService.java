package com.service;

import com.models.Category;


import java.util.List;

public interface CategoryService {
    List<Category> readAll();
    Category update(Category category);
    Integer delete(Integer id);
    Category create(Category category);
}
