package com.trzas.coronatrace;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CoronaApi {

    @GET("api/data/getContaminatedData")
    Call<List<LocationDTO>> getContaminatedData(@Path("date") String date);

    @POST("api/Submission/SendData")
    Call<String> SendSubmission(@Body List<LocationDTO> locations);
}
