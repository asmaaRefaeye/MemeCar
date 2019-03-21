package com.inq.eslamwael74.meme.Rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.inq.eslamwael74.meme.ApiModel.Brand;

import java.util.List;

/**
 * Created by Omar on 2/12/2018.
 */

public class BrandResponse {
    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("data")
    @Expose
    public List<Brand> data = null;
    private final static long serialVersionUID = 5221634422796079144L;
}
