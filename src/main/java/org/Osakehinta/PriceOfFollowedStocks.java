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
    Scanner scanner = new Scanner(System.in);
    public void priceOfFollowedStocks(ArrayList<String> stockList) {
        System.out.print("Set your Alpha Vantage API key: ");
        String APIkey = scanner.nextLine();
        //HTTPClient instance
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
