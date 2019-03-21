package com.inq.eslamwael74.meme.ApiModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Omar on 2/12/2018.
 */

public class Brand {
    @SerializedName("brand_id")
    @Expose
    public String brandId;
    @SerializedName("brand_car_name")
    @Expose
    public String brandCarName;
    private final static long serialVersionUID = -8129622952627982204L;
}
