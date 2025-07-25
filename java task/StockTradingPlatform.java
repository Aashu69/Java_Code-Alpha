import java.util.*;

public class StockTradingPlatform {

    static class Stock {
        String symbol;
        double price;

        Stock(String symbol, double price) {
            this.symbol = symbol;
            this.price = price;
        }
    }

    static class Holding {
        Stock stock;
        int quantity;

        Holding(Stock stock, int quantity) {
            this.stock = stock;
            this.quantity = quantity;
        }

        double getValue() {
            return stock.price * quantity;
        }
    }

    static class User {
        String name;
        Map<String, Holding> portfolio = new HashMap<>();

        User(String name) {
            this.name = name;
        }

        void buyStock(Stock stock, int quantity) {
            portfolio.putIfAbsent(stock.symbol, new Holding(stock, 0));
            portfolio.get(stock.symbol).quantity += quantity;
            System.out.println("Bought " + quantity + " shares of " + stock.symbol);
        }

        void sellStock(Stock stock, int quantity) {
            Holding h = portfolio.get(stock.symbol);
            if (h == null || h.quantity < quantity) {
                System.out.println("Not enough shares to sell.");
            } else {
                h.quantity -= quantity;
                System.out.println("Sold " + quantity + " shares of " + stock.symbol);
            }
        }

        void showPortfolio() {
            System.out.println("Portfolio for " + name + ":");
            double total = 0;
            for (Holding h : portfolio.values()) {
                System.out.println(h.stock.symbol + ": " + h.quantity + " shares @ $" + h.stock.price);
                total += h.getValue();
            }
            System.out.printf("Total Value: $%.2f\n", total);
        }
    }
    }
