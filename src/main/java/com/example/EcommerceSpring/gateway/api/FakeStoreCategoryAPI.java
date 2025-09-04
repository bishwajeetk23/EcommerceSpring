package com.example.EcommerceSpring.gateway.api;

import com.example.EcommerceSpring.dtos.FakeStoreResponseCategoryDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;

public interface FakeStoreCategoryAPI {
    // add retrofit and gson converter
    @GET("products/category")
    Call<FakeStoreResponseCategoryDTO> getAllFakeCategories() throws IOException;
}
