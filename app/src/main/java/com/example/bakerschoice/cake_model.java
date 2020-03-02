package com.example.bakerschoice;

public class cake_model {

    private String item_name;
    private String item_prize;

    public cake_model(){

    }

    public cake_model(String item_name,String item_prize){
        this.item_name=item_name;
        this.item_prize=item_prize;
    }

    public String getItem_name(){
        return item_name;
    }

    public String getItem_prize(){
        return item_prize;
    }
}
