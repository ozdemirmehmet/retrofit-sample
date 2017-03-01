package com.example.happydigital.retrofitexample;

/**
 * Created by happydigital on 28.02.2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrofitModel {

    @SerializedName("category")
    @Expose
    public String category;
    @SerializedName("price")
    @Expose
    public Float price;
    @SerializedName("instructions")
    @Expose
    public String instructions;
    @SerializedName("photo")
    @Expose
    public String photo;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("productId")
    @Expose
    public Integer productId;

}