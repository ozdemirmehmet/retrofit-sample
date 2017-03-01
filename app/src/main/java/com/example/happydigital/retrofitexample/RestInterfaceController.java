package com.example.happydigital.retrofitexample;

/**
 * Created by happydigital on 28.02.2017.
 */

import com.google.gson.JsonElement;
import com.squareup.okhttp.RequestBody;

import org.json.JSONObject;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedInput;

public interface RestInterfaceController {

    // GET yada POST mu olduğunu belirliyoruz.
    @GET("/servejson")
    void getJsonValues(Callback<RetrofitModel[]> response);

    @GET("/login.php")
    void getJsonGet(@Query("username") String username, @Query("password") String password, Callback<Login> response);

    //@Multipart
    @Headers({
            "Accept: application/json",
    })
    @POST("/u/gupdts")
    //Parametre sayısı az ise böyle de tanımlanabilir
//    void getJsonPost(@Part("p0") RequestBody a, Callback<JsonElement> response);
    //Parametre fazlaysa json nesnesini bir string e atıp ordan typed input a convert ederek çağırdık.
    //Gson ile parse yapamıyorsak Callback' e JsonElement parametresini veririz.
    //Gelen veriden json parse işlemini el ile yaparız.
    void getJsonPost(@Body TypedInput a, Callback<JsonElement> response);
}
