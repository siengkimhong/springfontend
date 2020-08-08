package com.kimhong.springfontend.retrofit.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiGenerator {

    private static final String BASE_URL = "http://localhost:9001/api/v1/";
    private static final OkHttpClient httpClient = new OkHttpClient.Builder().build();
    private static final Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient);

    private static final Retrofit retrofit = builder.build();
    public static <S> S createService(Class<S> className){
        return retrofit.create(className);
    }
}
