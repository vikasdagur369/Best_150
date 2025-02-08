// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

// we have to sell the stock with maximum profit. means buy at low cost and sell at max.

// brute force approach is very easy. we have to run two for loops.

// for optimal approach we have to find that when we are going to get max profit.

// we will use 3 variables , buy , sell and proit.

// we can solve this in 0(n) using single for loop.

// using three varibles, 


class Solution {
    public int maxProfit(int[] prices) {
        
        int min = prices[0];  // will store the first value of price in min.
        
        int profit = 0;

        for(int i=0; i<prices.length;i++){

            // at any situation , if value of price is less than min then update min.
            if(prices[i] < min){
                min = prices[i];
            }
            
            // calculating the profit for all value
            profit = Math.max(profit, prices[i]-min);
        }

        return profit;
    }
}