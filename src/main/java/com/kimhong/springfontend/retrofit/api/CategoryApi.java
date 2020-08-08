package com.kimhong.springfontend.retrofit.api;

import com.kimhong.springfontend.retrofit.model.ApiResponse;
import com.kimhong.springfontend.retrofit.model.Category;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface CategoryApi {

    @GET("categories")
    Call<ApiResponse<List<Category>>> getCategories();

    @GET("categories/{id}")
    Call<ApiResponse<Category>> getCategoryById(@Path("id") int id);
}
