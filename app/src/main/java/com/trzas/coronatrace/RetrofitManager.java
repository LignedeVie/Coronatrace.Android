package com.trzas.coronatrace;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private Retrofit retrofit;
    private CoronaApi serviceApi;
    private String baseUrl = "http://ec2-18-185-67-37.eu-central-1.compute.amazonaws.com/";

    private Retrofit getClient() {
        if(retrofit != null)
            return retrofit;

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }
    private CoronaApi getApiService() {
        if(serviceApi != null)
            return serviceApi;

        Retrofit retro = getClient();
        serviceApi = retro.create(CoronaApi.class);

        return serviceApi;
    }

    public List<LocationDTO> GetContaminatedData(Date lastCheck) {
        CoronaApi api = getApiService();
        Call<List<LocationDTO>> call = api.getContaminatedData(lastCheck.toString());
        call.enqueue(new Callback<List<LocationDTO>>() {
            @Override
            public void onResponse(Call<List<LocationDTO>> call, Response<List<LocationDTO>> response) {

            }

            @Override
            public void onFailure(Call<List<LocationDTO>> call, Throwable t) {

            }
        });

        return null;
    }
}
