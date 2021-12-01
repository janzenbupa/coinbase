package com.api.prices;

public class PriceWrapper {
    private Price data;

    public Price getData(){
        if (this.data == null)
            this.data = new Price();
        return this.data;
    }
    public void setData(Price price){
        this.data = price;
    }
}
