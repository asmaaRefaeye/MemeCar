package com.inq.eslamwael74.meme.ApiModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Omar on 2/12/2018.
 */

public class City {
    @SerializedName("city_id")
    @Expose
    public int cityId;
    @SerializedName("city_name")
    @Expose
    public String cityName;
}
