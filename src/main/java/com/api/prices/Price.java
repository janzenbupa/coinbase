package com.api.prices;

public class Price {
    private Double amount;
    private String currency;

    public Double getAmount(){
        return this.amount;
    }
    public void setAmount(Double _amount){
        this.amount = _amount;
    }

    public String getCurrency(){
        return this.currency;
    }
    public void setCurrency(String _currency){
        this.currency = _currency;
    }
}
