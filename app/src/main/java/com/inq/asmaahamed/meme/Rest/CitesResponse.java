package com.inq.eslamwael74.meme.Rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.inq.eslamwael74.meme.ApiModel.City;

import java.util.List;

/**
 * Created by Omar on 2/12/2018.
 */

public class CitesResponse {
    @SerializedName("code")
    @Expose
    public int code;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("data")
    @Expose
    public List<City> data;

}
