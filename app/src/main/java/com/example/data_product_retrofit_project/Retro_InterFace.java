package com.example.data_product_retrofit_project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Retro_InterFace {
     @GET("todos")
    Call<List<DataModelClas>>ShowProduct();
}
