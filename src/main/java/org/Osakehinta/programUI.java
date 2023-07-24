package org.Osakehinta;

import java.util.Scanner;

class programUI {
    private Scanner scanner;
    private StockFollowing stockFollowing;
    private PriceOfFollowedStocks priceOfFollowedStocks;

    public programUI() {
        scanner = new Scanner(System.in);
        stockFollowing = new StockFollowing();
        priceOfFollowedStocks = new PriceOfFollowedStocks();
    }
    public void mainMenu() {
        String option;
        while (true) {
            System.out.print("MAIN MENU \n \n 1. Add or remove followed stocks \n 2. Show stocks I follow \n 3. Set your AlphaVantage API key (mandatory for showing the prices of stocks) \n 0. Exit the app \n Choose the option by typing the number: ");
            option = scanner.nextLine();
            if (option.equals("0")) {
                break;
            } else if (option.equals("1")) {
                addingRemovingStocksMenu();
            }
            else if (option.equals("2")) {
                showFollowedStocksMenu();
            }
            else if (option.equals("3")) {
                priceOfFollowedStocks.setAPIkey();
            }
            else {
                System.out.println("Incorrect input, check for a typo.");
            }
        }
    }

    public void addingRemovingStocksMenu() {
        String option;
        while (true) {
            System.out.print("\n Type 1 to add new stocks to your stockfollowlist \n Type 2 to remove stocks from your stockfollowlist \n Type 0 to exit to main menu: ");
            option = scanner.nextLine();
            if (option.equals("1")) {
                stockFollowing.collectStockSymbols();
            } else if (option.equals("2")) {
                stockFollowing.deleteStockFollowing();
            } else if (option.equals("0")) {
                //Printing an empty line to get back to main menu
                System.out.println("");
                break;
            } else {
                System.out.println("Incorrect input, check for a typo.");
            }
        }
    }

    public void showFollowedStocksMenu() {
        String option;
        while (true) {
            System.out.print("Type 1 to print the stocks I follow \n Type 2 to print the prices of the followed stocks \n Type 0 to exit to main menu: ");
            option = scanner.nextLine();
            if (option.equals("1")) {
                stockFollowing.printStockSymbols();
            } else if (option.equals("2")) {
                priceOfFollowedStocks.priceOfFollowedStocks(stockFollowing.getStockFollowList());
            } else if (option.equals("0")) {
                //Exiting to main menu //
                break;
            } else {
                System.out.println("Incorrect input, check for a typo.");
            }
        }
    }
}
