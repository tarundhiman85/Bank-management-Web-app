package com.project.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Stocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("01. symbol")
    @Column(name ="Name")
    private String symbol;
    @JsonProperty("02. open")
    @Column(name ="openFor")
    private String open;
    @JsonProperty("03. high")
    @Column(name ="highFor")
    private String high;
    @JsonProperty("04. low")
    @Column(name ="lowFor")
    private String low;
    @JsonProperty("05. price")
    @Column(name ="priceFor")
    private String price;
    @JsonProperty("06. volume")
    @Column(name ="volumeFor")
    private String volume;
    @JsonProperty("07. latest trading day")
    @Column(name ="tradingDay")
    private String latestTradingDay;
    @JsonProperty("08. previous close")
    @Column(name ="prevCloseFor")
    private String prevClose;
    @JsonProperty("09. change")
    @Column(name ="changeFor")
    private String change;
    @JsonProperty("10. change percent")
    @Column(name ="changePercentFor")
    private String changePercent;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    private Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Stocks(String symbol, String open, String high, String low, String price, String volume, String latestTradingDay, String prevClose, String change, String changePercent) {
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.price = price;
        this.volume = volume;
        this.latestTradingDay = latestTradingDay;
        this.prevClose = prevClose;
        this.change = change;
        this.changePercent = changePercent;
    }

    public Stocks() {

    }


    public String getSymbol() {
        return symbol;
    }

    public String getLatestTradingDay() {
        return latestTradingDay;
    }

    public void setLatestTradingDay(String latestTradingDay) {
        this.latestTradingDay = latestTradingDay;
    }

    public void setSymbol(String nameStock) {
        this.symbol = nameStock;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(String changePercent) {
        this.changePercent = changePercent;
    }

    public String getPrevClose() {
        return prevClose;
    }

    public void setPrevClose(String prevClose) {
        this.prevClose = prevClose;
    }
}
