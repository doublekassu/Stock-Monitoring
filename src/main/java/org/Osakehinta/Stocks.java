package org.Osakehinta;
import java.util.ArrayList;
import java.util.Scanner;

class Stocks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> stockFollowList = new ArrayList();
        String stockSymbol = "";
        while (true) {
            System.out.print("Enter the stock symbol of the stock you want to follow. Type 'stop' if you want to stop adding stock follows: ");
            stockSymbol = scanner.nextLine();
            if (stockSymbol.equals("stop")) {
                break;
            }
            stockFollowList.add(stockSymbol);
        }
        for (String symbol : stockFollowList) {
            System.out.println(symbol);
        }
    }
}
