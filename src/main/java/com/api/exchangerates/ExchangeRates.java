package com.api.exchangerates;

import java.util.HashMap;

public class ExchangeRates {
    private String currency;
    private HashMap<String, Double> rates;

    public String getCurrency(){
        return this.currency;
    }
    public void setCurrency(String _currency){
        this.currency = _currency;
    }

    public HashMap<String, Double> getRates(){
        if (this.rates == null)
            this.rates = new HashMap();
        return this.rates;
    }
    public void setRates(HashMap<String, Double> _rates){
        this.rates = _rates;
    }
}
