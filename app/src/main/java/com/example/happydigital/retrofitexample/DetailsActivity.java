package com.example.happydigital.retrofitexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by happydigital on 28.02.2017.
 */

public class DetailsActivity extends Activity {

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();
        String photoName = bundle.getString("image_name");

        image = (ImageView)findViewById(R.id.img_detail);

        Picasso.with(getApplicationContext())
                .load(Constants.URL_IMAGES+photoName)
                .resize(500,500)
                .into(image);
    }
}
