package com.kimhong.springfontend.controller;

import com.kimhong.springfontend.retrofit.model.ApiResponse;
import com.kimhong.springfontend.retrofit.model.Article;
import com.kimhong.springfontend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private ArticleService service;

    @Value("${api.image-uri}")
    String imageUri;

    @Autowired
    public void setService(ArticleService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewHomePage(ModelMap map){
        ApiResponse<List<Article>> recentArticles = service.getRecentArticles();
        ApiResponse<List<Article>> popularArticle = service.getPopularArticle();
        map.addAttribute("recentArticles", recentArticles.getData());
        map.addAttribute("imageUri", imageUri);
        map.addAttribute("popularArticles", popularArticle.getData());
        return "pages/index";
    }


}
