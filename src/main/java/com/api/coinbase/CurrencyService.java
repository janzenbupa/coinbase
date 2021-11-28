package com.api.coinbase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.bytebuddy.description.method.MethodDescription;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class CurrencyService implements CurrencyRepository{
    private String _url = "https://api.coinbase.com/v2/";

    public Currency findCurrencyByName(String _id){
        CurrencyWrapper currencies = getCurrenciesRequest();

        if (currencies != null && currencies.getData().size() > 0){
            for (Currency c : currencies.getData()){
                if (c.getId().equals(_id))
                    return c;
            }
        }

        return null;
    }

    public ArrayList<Currency> findCurrencies(){
        CurrencyWrapper currencies = this.getCurrenciesRequest();

        if (currencies != null)
            return currencies.getData();
        return new ArrayList<Currency>();
    }

    private CurrencyWrapper getCurrenciesRequest() {
        _url += "currencies";

        try {
            URL url = new URL(_url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("content-type", "application/json");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
            in.close();

            CurrencyWrapper currencies = Deserialize(stringBuilder.toString());
            return currencies;
        }
        catch (IOException ex){
            return null;
        }
    }

    private CurrencyWrapper Deserialize(String response){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        CurrencyWrapper currencies = gson.fromJson(response, CurrencyWrapper.class);

        return currencies;
    }

    public <T> String Serialize(T obj){
        Gson gson = new Gson();
        String json = gson.toJson(obj);

        return json;
    }
}