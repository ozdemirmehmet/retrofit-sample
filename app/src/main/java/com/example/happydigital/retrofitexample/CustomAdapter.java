package com.example.happydigital.retrofitexample;

/**
 * Created by happydigital on 28.02.2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Items> {

    private Context context;
    private ViewHolder viewHolder;
    private List<Items> arrayList = new ArrayList<Items>();
    public CustomAdapter(Context context, List<Items> list_items) {

        super(context, R.layout.item_layout, list_items);
        this.context = context;
        this.arrayList = list_items;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null){

            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.item_layout, parent,false);

            viewHolder = new ViewHolder();
            viewHolder.txt_name = (TextView)view.findViewById(R.id.name);
            viewHolder.image = (ImageView)view.findViewById(R.id.img);
            viewHolder.category = (TextView)view.findViewById(R.id.category);
            viewHolder.price = (TextView)view.findViewById(R.id.price);

            view.setTag(viewHolder);


        }else{

            viewHolder = (ViewHolder) view.getTag();

        }

        //Items items_info = getItem(position);

        viewHolder.txt_name.setText("Name: " + "" + arrayList.get(position).getName());  // name değerini textview e atıyoruz

        viewHolder.category.setText("Category: " + "" + arrayList.get(position).getCategory()); // category değerini textview e atıyoruz

        viewHolder.price.setText("Price: " + "" + String.valueOf(arrayList.get(position).getPrice()).toString()); // price değerini textview e atıyoruz


        // picasso kütüphanesi kullanarak ilgili resmi aldıktan sonra imageview e set ettik
        Picasso.with(getContext()).load(Constants.URL_IMAGES+arrayList.get(position).getPhoto()).resize(300,300).into(viewHolder.image);


        return view;

    }



    private static class ViewHolder{

        TextView txt_name;
        ImageView image;
        TextView category;
        TextView price;
    }
}
