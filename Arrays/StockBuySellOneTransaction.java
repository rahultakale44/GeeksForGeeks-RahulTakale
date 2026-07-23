import java.util.Arrays;

public class StockBuySellOneTransaction {

    public static int maximumProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - minPrice;

            maxProfit = Math.max(maxProfit, currentProfit);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 10, 1, 3, 6, 9, 2};

        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Maximum profit: " + maximumProfit(prices));
    }
}