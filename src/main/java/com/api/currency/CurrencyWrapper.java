package com.api.currency;


import java.util.ArrayList;

public class CurrencyWrapper {
    private ArrayList<Currency> data;

    public ArrayList<Currency> getData(){
        if (this.data == null){
            this.data = new ArrayList<Currency>();
        }

        return this.data;
    }

    public void setData(ArrayList<Currency> _data){
        this.data = _data;
    }


}
