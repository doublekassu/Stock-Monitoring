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
        //API key
        String apiURL = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=NVDA&apikey=LOJCQIVJYQ0D2H2Q";

        //HTTPClient instance
        HttpClient httpClient = HttpClientBuilder.create().build();

        try {
            //GET request to the API
            HttpGet request = new HttpGet(apiURL);
            HttpResponse response = httpClient.execute(request);

            //Parse the JSON response
            String jsonResponse = EntityUtils.toString(response.getEntity());
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

            // Extract the stock price from the JSON data
            JsonObject globalQuote = jsonObject.getAsJsonObject("Global Quote");
            String stockPrice = globalQuote.get("05. price").getAsString();

            // Print the stock price
            System.out.println("Current stock price: " + stockPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}