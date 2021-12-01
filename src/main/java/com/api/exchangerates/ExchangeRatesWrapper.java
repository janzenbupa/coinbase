package com.api.exchangerates;

import java.util.ArrayList;

public class ExchangeRatesWrapper {
    private ExchangeRates data;

    public ExchangeRates getData(){
        if (this.data == null)
            this.data = new ExchangeRates();
        return this.data;
    }
    public void setData(ExchangeRates rates){
        this.data = rates;
    }
}
