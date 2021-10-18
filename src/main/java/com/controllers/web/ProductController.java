package com.controllers.web;

import com.models.Product;
import com.service.CategoryService;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(name = "")
    public String readAll(Model model){
        model.addAttribute("list",productService.readAll());
        return "product/home_page";
    }

    @GetMapping("/create")
    public String viewCreate(Model model){
        model.addAttribute("productForm",new Product());
        model.addAttribute("listCate",categoryService.readAll());
        return "product/create";
    }

    @PostMapping("/create")
    public String saveProduct(@ModelAttribute("productForm") @Valid Product product, BindingResult result, RedirectAttributes attributes, Model model){
        if(result.hasErrors()) {
            model.addAttribute("listCate",categoryService.readAll());
            return "product/create";
        }else {
            productService.create(product);
            attributes.addFlashAttribute("message", "Create Product is successfuly with id :" + product.getId());
            return "redirect:/product";
        }
    }

    @GetMapping("/update/{id}")
    public String editView(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("productForm", productService.detail(id));
        model.addAttribute("listCate", categoryService.readAll());
        return "product/update";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@Valid @ModelAttribute("productForm") Product product, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()){
            return "product/update";
        }else {
            productService.update(product);
            attributes.addFlashAttribute("message","Update Product is successfuly with id :" + product.getId());
            return "redirect:/product";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        productService.delete(id);
        return "redirect:/product";
    }

}
