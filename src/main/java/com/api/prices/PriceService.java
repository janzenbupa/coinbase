package com.api.prices;

import com.api.currency.CurrencyWrapper;
import com.api.gson.GsonSerializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PriceService {
    private String _url = "https://api.coinbase.com/v2/prices/";

    public PriceWrapper getBuyPrices(String currencyPair){
        _url = "https://api.coinbase.com/v2/prices/";
        return this.getPricesRequest(currencyPair, "buy");
    }

    public PriceWrapper getSellPrices(String currencyPair){
        _url = "https://api.coinbase.com/v2/prices/";
        return this.getPricesRequest(currencyPair, "sell");
    }

    private PriceWrapper getPricesRequest(String currencyPair, String buySell){
        _url += currencyPair + "/" + buySell;

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

            PriceWrapper prices = new GsonSerializer().deserialize(stringBuilder.toString(), PriceWrapper.class);
            return prices;
        }
        catch (IOException ex){
            return null;
        }
    }
}
