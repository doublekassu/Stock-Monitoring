package org.Osakehinta;
import java.util.ArrayList;
import java.util.Scanner;

class StockFollowing {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<String> stockFollowList;

    public StockFollowing() {
        stockFollowList = new ArrayList<>();
    }

    public ArrayList<String> getStockFollowList() {
        return stockFollowList;
    }

    public void collectStockSymbols() {
        while (true) {
            System.out.print("Enter the stock symbol of the stock you want to follow. Type 'stop' if you want to stop adding stock follows: ");
            String stockSymbol = scanner.nextLine();
            if (stockSymbol.equals("stop")) {
                break;
            }
            stockFollowList.add(stockSymbol);
        }
    }

    public void printStockSymbols() {
        if (stockFollowList.isEmpty()) {
            System.out.println("You haven't followed any stocks");
        }
        else {
            for (String symbol : stockFollowList) {
                System.out.println(symbol);
            }
        }
    }

    public void deleteStockFollowing() {
        if (stockFollowList.isEmpty()) {
            System.out.println("You haven't followed any stocks");
        }
        else {
            System.out.print("What stock would you like to stop following? ");
            String stockSymbol = scanner.nextLine();
            if (stockFollowList.contains(stockSymbol)) {
                stockFollowList.remove(stockSymbol);
            }
            else {
                System.out.println("You're not following that stock.");
            }
        }
    }

}
