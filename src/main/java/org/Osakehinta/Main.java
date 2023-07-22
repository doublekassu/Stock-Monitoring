package org.Osakehinta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StockFollowing stockFollowing = new StockFollowing();
        PriceOfFollowedStocks priceOfFollowedStocks = new PriceOfFollowedStocks();
        //Menu of the program
        while (true) {
            System.out.print("MAIN MENU \n \n 1. Explore stock options \n 2. Show stocks I follow \n 0. Exit the app \n Choose the option by typing the number: ");
            String option = scanner.nextLine();
            if (option.equals("0")) {
                break;
            }
            else if (option.equals("1")) {
                System.out.print("\n Type 1 to add new stocks to your stockfollowlist \n Type 2 to remove stocks from your stockfollowlist \n Type 0 to exit to main menu: ");
                option = scanner.nextLine();
                if (option.equals("1")) {
                    stockFollowing.collectStockSymbols();
                }
                else if (option.equals("2")) {
                    stockFollowing.deleteStockFollowing();
                }
                else if (option.equals("0")) {
                    //Printing an empty line to get back to main menu
                    System.out.println("");
                }
                else {
                    System.out.println("Incorrect input, check for a typo.");
                }
            }
        }
    }
}