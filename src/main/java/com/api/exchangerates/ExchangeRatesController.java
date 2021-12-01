package com.api.exchangerates;

import com.api.gson.GsonSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ExchangeRatesController {
    ExchangeRatesService ratesService = new ExchangeRatesService();

    @GetMapping("/exchange-rates")
    public String exchangeRates(){
        return new GsonSerializer().serialize(ratesService.getRates());
    }

    @GetMapping("/exchange-rates/{currency}")
    public String exchangeRatesCurrency(@PathVariable String currency){
        Double rate = ratesService.getRateByCurrency(currency);

        if (rate < 0)
            return "Could not retrieve rate or rate is negative";

        return new GsonSerializer().serialize(Map.of(currency, rate));
    }
}
