package com.kimhong.springfontend.service;

import com.kimhong.springfontend.retrofit.api.ApiGenerator;
import com.kimhong.springfontend.retrofit.api.ArticleApi;
import com.kimhong.springfontend.retrofit.model.ApiResponse;
import com.kimhong.springfontend.retrofit.model.Article;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Service
public class ArticleService {

    public ApiResponse<List<Article>> getRecentArticles(){
        ArticleApi articleApi = ApiGenerator.createService(ArticleApi.class);
        ApiResponse<List<Article>> articleRecentResponse = new ApiResponse<>();
        try {
            articleRecentResponse = articleApi.getRecentArticles().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return articleRecentResponse;
    }

    public ApiResponse<List<Article>> getPopularArticle(){
        ArticleApi articleApi = ApiGenerator.createService(ArticleApi.class);
        ApiResponse<List<Article>> articlePopularResponse = new ApiResponse<>();
        try {

            articlePopularResponse = articleApi.getPopularArticle().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return articlePopularResponse;
    }

}
