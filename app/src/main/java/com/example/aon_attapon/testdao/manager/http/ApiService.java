package com.example.aon_attapon.testdao.manager.http;

import com.example.aon_attapon.testdao.dao.carPositionCollection;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("users/{token}/carPositions/")
    Call<carPositionCollection> getHistoryPositions(@Path("token") String token);
}
