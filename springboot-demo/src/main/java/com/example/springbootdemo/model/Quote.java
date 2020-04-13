package com.example.springbootdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Details of the Quote")
public class Quote {

    @Schema(description = "This is the unique stock code")
    private String quote;
    @Schema(description = "This bid price of the stock")
    private BigDecimal bid;
    @Schema(description = "This ask price of the stock")
    private BigDecimal ask;

    public Quote(String quote, BigDecimal bid, BigDecimal ask) {
        this.quote = quote;
        this.bid = bid;
        this.ask = ask;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }
}
