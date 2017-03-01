package com.example.happydigital.retrofitexample;

/**
 * Created by happydigital on 28.02.2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("flag")
    @Expose
    public Integer flag;
    @SerializedName("room_number")
    @Expose
    public String roomNumber;
    @SerializedName("name_surname")
    @Expose
    public String nameSurname;
    @SerializedName("token")
    @Expose
    public String token;
    @SerializedName("user_id")
    @Expose
    public String userId;

}