package com.example.happydigital.retrofitexample;

/**
 * Created by happydigital on 28.02.2017.
 */

import android.graphics.Bitmap;

public class Items   {

    private String name;
    private int productId;
    private String category;
    private double price;
    private Bitmap bitmap;
    private String instructions;
    private String photo;

    public void setName(String name){

        this.name = name;
    }
    public String getName(){

        return this.name;
    }
    public void setProductId(int productId){

        this.productId = productId;
    }
    public int getProductId(){

        return this.productId;
    }
    public void setCategory(String category){

        this.category = category;
    }
    public String getCategory(){

        return this.category;
    }
    public void setPrice(double price){

        this.price = price;
    }
    public double getPrice(){

        return this.price;
    }
    public void setBitmap(Bitmap bitmap){

        this.bitmap = bitmap;
    }
    public Bitmap getBitmap(){

        return this.bitmap;
    }
    public void setInstructions(String instructions){

        this.instructions = instructions;
    }
    public String getInstructions(){

        return this.instructions;
    }
    public void setPhoto(String photo){

        this.photo = photo;
    }
    public String getPhoto(){

        return this.photo;
    }

}
