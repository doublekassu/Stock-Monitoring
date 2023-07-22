package org.Osakehinta;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Scanner;


class PriceOfFollowedStocks {
    private String APIkey;
    private int APIkeylength = 16;
    Scanner scanner = new Scanner(System.in);

    public void setAPIkey() {
        System.out.print("Set your Alpha Vantage API key: ");
        APIkey = scanner.nextLine();
        if (APIkey.length() == APIkeylength) {
            System.out.println("The given API key is correct");
        }
        else {
            System.out.println("The given API key is incorrect");
            APIkey = "";
        }
    }
    public void priceOfFollowedStocks(ArrayList<String> stockList) {
        //HTTPClient instance
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        try {
            if (APIkey.length() == APIkeylength) {
                for (String symbol : stockList) {
                    //API URL for each stock symbol
                    String apiURL = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + APIkey;

                    //GET request to the API
                    HttpGet request = new HttpGet(apiURL);
                    HttpResponse response = httpClient.execute(request);

                    // Parse the JSON response
                    String jsonResponse = EntityUtils.toString(response.getEntity());
                    JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

                    // Extract the stock price from the JSON data
                    JsonObject globalQuote = jsonObject.getAsJsonObject("Global Quote");
                    String stockPrice = globalQuote.get("05. price").getAsString();

                    //Print the stock price
                    System.out.println("The closing price of " + symbol + ": " + stockPrice);
                }
            }
            else {
                System.out.println("The given API key is incorrect");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
