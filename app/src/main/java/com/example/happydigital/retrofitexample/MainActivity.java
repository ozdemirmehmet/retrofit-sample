package com.example.happydigital.retrofitexample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.JsonElement;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private ListView listView;
    private RestAdapter restAdapter;
    private RestInterfaceController restInterfaceController;
    private ProgressDialog progressDialog;
    private List<Items> list = new ArrayList<Items>();
    private CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById(R.id.startButton);
        listView = (ListView)findViewById(R.id.listview);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setCancelable(false);
                progressDialog.show();

                restAdapter = new RestAdapter.Builder()
                        .setEndpoint(Constants.URL)
                        .build();

                restInterfaceController = restAdapter.create(RestInterfaceController.class);
                restInterfaceController.getJsonValues(new Callback<RetrofitModel[]>() {
                    @Override
                    public void success(RetrofitModel[] retrofitModels, Response response) {

                        for (RetrofitModel model: retrofitModels){
                            Items item = new Items();
                            item.setName(model.name);
                            item.setCategory(model.category);
                            item.setInstructions(model.instructions);
                            item.setPhoto(model.photo);
                            item.setPrice(model.price);
                            item.setProductId(model.productId);
                            list.add(item);
                        }

                        progressDialog.cancel();

                        customAdapter = new CustomAdapter(getApplicationContext(), list);
                        listView.setAdapter(customAdapter);
                    }

                    @Override
                    public void failure(RetrofitError error) {

                        Log.d("Error", error.getMessage());
                        Toast.makeText(MainActivity.this, "Error=> "+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("image_name", list.get(position).getPhoto());
                startActivity(intent);
            }
        });


        //Get with parameters
        /*restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.URL2)
                .build();

        restInterfaceController = restAdapter.create(RestInterfaceController.class);

        restInterfaceController.getJsonGet("2","ozcan", new Callback<Login>() {
            @Override
            public void success(Login s, Response response) {
                String token = s.token;
                Log.d("MainActivity", token);
                Log.d("MainActivity", response.getUrl());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("","");
            }
        });
        */

        //Post with json parameters
        String json = "{\"p0\":\"JQGFHUGTCCEQRNMVSDJOSUXGMQTUUM09622F5719A3AEB3A87C4E097BCEC84D\",\"p1\":[{\"p0\":\"1\",\"p1\":\"0\"},{\"p0\":\"2\",\"p1\":\"0\"},{\"p0\":\"3\",\"p1\":\"0\"},{\"p0\":\"4\",\"p1\":\"0\"},{\"p0\":\"5\",\"p1\":\"0\"},{\"p0\":\"6\",\"p1\":\"0\"},{\"p0\":\"7\",\"p1\":\"0\"},{\"p0\":\"8\",\"p1\":\"0\"},{\"p0\":\"9\",\"p1\":\"0\"},{\"p0\":\"10\",\"p1\":\"0\"},{\"p0\":\"11\",\"p1\":\"0\"}]}";

        restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.URL3)
                .build();

        TypedInput in = null;
        try {
            in = new TypedByteArray("application/json", json.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        restInterfaceController = restAdapter.create(RestInterfaceController.class);

        restInterfaceController.getJsonPost(in, new Callback<JsonElement>() {
            @Override
            public void success(JsonElement hepvie, Response response) {
                Log.d("MainActivity", response.getUrl());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("MainActivity", error.getMessage());
            }
        });


    }
}
