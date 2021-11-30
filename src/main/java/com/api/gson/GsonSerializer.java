package com.api.gson;

import com.api.currency.CurrencyWrapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonSerializer {
    public <T> String Serialize(T obj){
        Gson gson = new Gson();
        String json = gson.toJson(obj);

        return json;
    }

    public CurrencyWrapper Deserialize(String response){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        CurrencyWrapper currencies = gson.fromJson(response, CurrencyWrapper.class);

        return currencies;
    }
}
