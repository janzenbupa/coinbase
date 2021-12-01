package com.api.gson;

import com.api.currency.CurrencyWrapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonSerializer {
    public <T> String serialize(T obj){
        Gson gson = new Gson();
        String json = gson.toJson(obj);

        return json;
    }

    public <T> T deserialize(String response, Class<T> t){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        T item = gson.fromJson(response, t);

        return item;
    }
}
