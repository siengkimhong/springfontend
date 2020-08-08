package com.kimhong.springfontend.service;

import com.kimhong.springfontend.retrofit.api.ApiGenerator;
import com.kimhong.springfontend.retrofit.api.CategoryApi;
import com.kimhong.springfontend.retrofit.model.ApiResponse;
import com.kimhong.springfontend.retrofit.model.Category;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CategoryService {

    private CategoryApi categoryApi;

    @PostConstruct
    private void init(){
        categoryApi = ApiGenerator.createService(CategoryApi.class);
    }

    public ApiResponse<List<Category>> getCategories(){
        ApiResponse<List<Category>> categories = new ApiResponse<>();
        try {
            categories = categoryApi.getCategories().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public CompletableFuture<ApiResponse<Category>> getCategoryById(int id){
        CompletableFuture<ApiResponse<Category>> categoryCompleted =
                new CompletableFuture<>();
        categoryApi.getCategoryById(id).enqueue(new Callback<ApiResponse<Category>>() {
            @Override
            public void onResponse(Call<ApiResponse<Category>> call, Response<ApiResponse<Category>> response) {
                categoryCompleted.complete(response.body());
            }

            @Override
            public void onFailure(Call<ApiResponse<Category>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return categoryCompleted;
    }
}
