package com.example.data_product_retrofit_project;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Instance_Class {
    public static Retro_InterFace CallAPI(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Retro_InterFace.class);
    }
}
