package com.kimhong.springfontend.controller;

import com.kimhong.springfontend.retrofit.model.ApiResponse;
import com.kimhong.springfontend.retrofit.model.Article;
import com.kimhong.springfontend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private ArticleService service;

    @Autowired
    public void setService(ArticleService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewHomePage(ModelMap map){
        ApiResponse<List<Article>> recentArticles = service.getRecentArticles();
        System.out.println(recentArticles.getData());
        map.addAttribute("recentArticles", recentArticles.getData());
        return "pages/index";
    }


}
