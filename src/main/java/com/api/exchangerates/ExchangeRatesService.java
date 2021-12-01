package com.api.exchangerates;

import com.api.gson.GsonSerializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class ExchangeRatesService {
    private String _url = "https://api.coinbase.com/v2/exchange-rates";

    public ExchangeRatesWrapper getRates(){
        return this.getRatesRequest();
    }

    public Double getRateByCurrency(String rate){
        ExchangeRatesWrapper rates = this.getRatesRequest();

        HashMap<String, Double> ratesList = rates.getData().getRates();

        if (ratesList.containsKey(rate))
            return ratesList.get(rate);
        return -1.0;
    }

    private ExchangeRatesWrapper getRatesRequest(){
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

            ExchangeRatesWrapper rates = new GsonSerializer().deserialize(stringBuilder.toString(), ExchangeRatesWrapper.class);
            return rates;
        }
        catch (IOException ex){
            return null;
        }
    }
}
