package com.project.Service;

import com.google.gson.Gson;
import com.project.entities.Stocks;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class StockService {
    private ArrayList<Stocks> stockList;
    private AtomicInteger id;

    public StockService() {
        this.stockList = new ArrayList<>();
        this.id = new AtomicInteger();
//        this.addStock(new Stock("Apple","2000","2500","1800","2000","1000","1","1","2100"));
    }
    public boolean createStock(String jsonPayload){
        if(jsonPayload == null) {
            return false;
        }
        Gson gson = new Gson();
        try{
            Stocks stock = (Stocks) gson.fromJson(jsonPayload, Stocks.class);
            if (stock == null) {
                return false;
            }
            this.addStock(stock);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addStock(Stocks stock) {
//        stock.setId(id.incrementAndGet());
        this.stockList.add(stock);
        return true;
    }

    public void removeStock(Stocks stock) {
        stockList.remove(stock);
    }

    public ArrayList<Stocks> getStockList() {
        return stockList;
    }
    public String getStockListJson() {
        return this.toJson(stockList);
    }
    public void setStockList(ArrayList<Stocks> stockList) {
        this.stockList = stockList;
    }

    public AtomicInteger getId() {
        return id;
    }

    public void setId(AtomicInteger id) {
        this.id = id;
    }

    /////////////////////////////private methods/////////////////////////////////////////////
    private String toJson(ArrayList<Stocks> stockList) {
        if(stockList == null) {
            return null;
        }
        Gson gson = new Gson();
        String json=null;
        try {
            json = gson.toJson(stockList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
