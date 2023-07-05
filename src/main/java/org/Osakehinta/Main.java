package org.Osakehinta;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Main {
    public static void main(String[] args) {
        StockFollowing myStocks = new StockFollowing();
        myStocks.collectStockSymbols();

        PriceOfFollowedStocks myPrices = new PriceOfFollowedStocks();
        myPrices.priceOfFollowedStocks(myStocks.getStockFollowList());
    }
}