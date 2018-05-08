package com.railsfactory.anurag.androidlibrarytutorials;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCheck {
    String BASE_URL_CHECK = "http://hpe.parkingrhino.in/api/";

    @GET("occupancy")
    Call<List<Check>> getApi();

}
