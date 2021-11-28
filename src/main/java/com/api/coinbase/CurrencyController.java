package com.api.coinbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CurrencyController {

    //@Autowired
    private CurrencyRepository _currencyRepository = new CurrencyService();

    @GetMapping("/currencies")
    public String Currencies(){
        ArrayList<Currency> currencies = this._currencyRepository.findCurrencies();

        if (currencies != null)
            return this._currencyRepository.Serialize(currencies);
        return "Could not retrieve currencies.";
    }

    @GetMapping("/currency/{id}")
    public String CurrencyByName(@PathVariable String id){
        Currency currency = this._currencyRepository.findCurrencyByName(id);

        return currency != null ? "{ " + String.format("{currency.getId()}: {currency.getName()}: {currency.getMin_size()}") + "}" : "";
    }
}
