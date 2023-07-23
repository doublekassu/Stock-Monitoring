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
        int calculator = 1;
        if (stockFollowList.isEmpty()) {
            System.out.println("You're not following any stocks");
        } else {
            System.out.println("\n Right now you are following these stocks: ");
            for (String symbol : stockFollowList) {
                if (calculator == stockFollowList.size()) {
                    System.out.println(symbol + "\n");
                }
                else {
                    System.out.print(symbol + ", ");
                }
                calculator++;
            }
        }
    }

    public void deleteStockFollowing() {
        while (true) {
            if (stockFollowList.isEmpty()) {
                System.out.println("You're not following any stocks");
            } else {
                printStockSymbols();
                System.out.print("Type the stock you want to stop following. To stop removing stocks press ENTER: ");
                String stockSymbol = scanner.nextLine();

                if (stockFollowList.contains(stockSymbol)) {
                    System.out.println(stockSymbol + " removed successfully!");
                    stockFollowList.remove(stockSymbol);
                }
                else if (stockSymbol.equals("")) {
                    System.out.println("Exiting stock removing menu \n");
                        break;
                    }
                else {
                    System.out.println("You're not following that stock.");
                }
            }
        }
    }
}
