package com.service;

import com.models.Product;
import com.repository.CategoryRepository;
import com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> readAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        Product entity=new Product();
        try {
            String localDate = LocalDate.now().toString();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(localDate);
            entity.setCreateDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        productRepository.save(product);
        entity.setId(product.getId());
        return entity;
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product detail(Integer id) {
        Optional<Product> optional = productRepository.findById(id);
        if(optional.isPresent()) {
            Product product = optional.get();
            return product;
        }
        return null;
    }

    @Override
    public Product update(Product product) {
        Optional<Product> optional=productRepository.findById(product.getId());
        if (optional.isPresent()){
            Product entity=optional.get();
            try {
                String localDate = LocalDate.now().toString();
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(localDate);
                entity.setCreateDate(date);
                productRepository.save(product);
                entity.setId(product.getId());
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return entity;
        }
        return null;
    }

    @Override
    public Product delete(Integer id) {
        Optional<Product> optional=productRepository.findById(id);
        if (optional.isPresent()) {
            Product entity = optional.get();
            productRepository.delete(entity);
            return entity;
        } else {
            return null;
        }
    }

}
