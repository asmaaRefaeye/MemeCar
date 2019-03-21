package com.inq.eslamwael74.meme.Rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Omar on 2/12/2018.
 */

public interface ApiInterface {

//we need models ..lets start

    public static final String APP_ID="100000665443";


    @GET("index.php?a=cities&app="+APP_ID)  //i am not sure but lets try  ok
    Call<CitesResponse> getAllCities(@Query("token") String userToken) ;   //i dont know what is user token >>if it is of every user so keep it in the method parameters ok ?
    // ok      iam very very very angry o
//tmam ? tmam  wait something wrong wait ok
}
