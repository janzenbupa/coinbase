package com.api.prices;

import com.api.gson.GsonSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {
    private PriceService _priceService = new PriceService();

    @GetMapping("/buy-prices/{currencyPair}")
    public String buyPrices(@PathVariable String currencyPair){
        return new GsonSerializer().serialize(this._priceService.getBuyPrices(currencyPair));
    }

    @GetMapping("/sell-prices/{currencyPair}")
    public String sellPrices(@PathVariable String currencyPair){
        return new GsonSerializer().serialize(this._priceService.getSellPrices(currencyPair));
    }
}
