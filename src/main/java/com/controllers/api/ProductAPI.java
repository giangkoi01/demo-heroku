package com.controllers.api;

import com.models.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductAPI {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> findAll() {
        return productService.readAll();
    }

    @PostMapping("/product")
    public Product create(@RequestBody Product product) {
            return productService.create(product);
    }

    @PutMapping("/product")
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("product/{id}")
    public Product delete(@PathVariable Integer id) {
        return productService.delete(id);
    }

}
