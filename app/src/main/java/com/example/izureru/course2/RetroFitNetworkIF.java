package com.example.izureru.course2;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import java.util.Date;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by izureru on 06/10/15.
 */
public class RetroFitNetworkIF {
    private static RestAdapter restAdapter;
    private static RetroFitNetworkService retroFitNetworkService;
    private static String baseURL= "http://192.168.1.125:4567";

    private static RestAdapter getAdapter(){
        if (restAdapter == null){
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .registerTypeAdapter(Date.class, new DateTypeAdapter())
                    .create();

            restAdapter = new RestAdapter.Builder()
                    .setEndpoint(baseURL)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setConverter(new GsonConverter(gson))
                    .build();
        }
        return restAdapter;
    }

    public static RetroFitNetworkService retroFitNetworkService(){
        if (retroFitNetworkService == null){
            retroFitNetworkService = getAdapter().create(RetroFitNetworkService.class);
        }
        return retroFitNetworkService;
    }
}
