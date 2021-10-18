package com.service;

import com.models.Category;
import com.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> readAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public Category create(Category category) {
        return null;
    }
}
