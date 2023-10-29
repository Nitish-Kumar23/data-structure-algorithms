package Leetcode;

public class BuySellStockII {

    // 7,1,5,3,6,4
    public static int maxProfit(int[] prices) {
        if(prices.length==1){
            return 0;
        }
        int maxProfit = 0;
        int buyDay = 0;
        int sellDate = 1;
        while (buyDay<prices.length && sellDate<prices.length){
            int profit = prices[sellDate] - prices[buyDay];
            if(profit>=0){
                maxProfit = maxProfit + profit;
                buyDay = sellDate;
                sellDate++;
            }
            if(profit<0){
                buyDay++;
                sellDate++;
            }
            
        }
        return maxProfit;
    }
    
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,3}));
    }
}
