package com.example.izureru.course2;

import java.util.List;

import javax.security.auth.callback.Callback;

import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by izureru on 06/10/15.
 */
public interface RetroFitNetworkService {
    @GET("/testService")
    void listPersons(retrofit.Callback<List<Person>> callback);
//    @POST("")
}
