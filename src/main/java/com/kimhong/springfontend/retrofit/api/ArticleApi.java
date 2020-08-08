package com.kimhong.springfontend.retrofit.api;


import com.kimhong.springfontend.retrofit.model.ApiResponse;
import com.kimhong.springfontend.retrofit.model.Article;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ArticleApi {

    @GET("articles/recent/3")
    Call<ApiResponse<List<Article>>> getRecentArticles();

}
