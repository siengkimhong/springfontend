package com.kimhong.springfontend.controller;

import com.kimhong.springfontend.retrofit.model.ApiResponse;
import com.kimhong.springfontend.retrofit.model.Category;
import com.kimhong.springfontend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.ExecutionException;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public String index(ModelMap map){
        map.addAttribute("api", service.getCategories().getData());
        return "index";
    }

    @GetMapping("/{id}")
    public String getCategoryByIdView(ModelMap map, @PathVariable("id") int id){
        ApiResponse<Category> category = new ApiResponse<>();
        try {
            category = service.getCategoryById(id).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        map.addAttribute("api", category.getData());
        return "index";
    }
}
