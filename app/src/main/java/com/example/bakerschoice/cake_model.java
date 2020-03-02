package com.example.bakerschoice;

public class cake_model {

    private String name;
    private String price;

    public cake_model(){

    }

    public cake_model(String name,String price){
        this.name=name;
        this.price=price;
    }

    public String getItem_name(){
        return name;
    }

    public String getItem_prize(){
        return price;
    }
}
