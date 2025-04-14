package Arrays;

//Best Time to Buy and Sell Stock

public class BuyNSellStock {
    public static int stockProfit(int arr[]) {
        int maxProfit = 0, buyPrice = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            buyPrice = Math.min(buyPrice, arr[i]);
            maxProfit = Math.max((arr[i] - buyPrice) , maxProfit);
        }
        return maxProfit;
    } 

    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4};
        System.out.println("Profit : " + stockProfit(arr));
    }
}