import org.junit.Test;

public class Solution309 {
    @Test
    public void test(){
        int[] prices={1,2,3,0,2};
        int[] prices1={4,6,3,5,7};
        int[] prices2={1};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices1));
        System.out.println(maxProfit(prices2));
    }
    public int maxProfit(int[] prices) {
        int[] arr={0};
        maxProfit(prices,0,0,false,arr);  // condition -> true:买, false:卖 ; profit= ∑(-1)^m * prices[i] 
        return arr[0];
    }
    private void maxProfit(int[] prices, int i, int profit, boolean condition, int[] arr) {
        if(i>=prices.length) {
            if(profit>arr[0]) arr[0]=profit;
            return;
        }
        if (condition==false) {
            if(i!=0)    i++;                                                     // 冷冻期
            maxProfit(prices,i+1,profit,condition,arr);                         // 跳过
            maxProfit(prices,i+1,profit-prices[i] ,true,arr);        // 买prices[i] 
        }
        else {
            maxProfit(prices,i+1,profit,condition,arr);                     // 跳过
            maxProfit(prices,i+1,profit+prices[i] ,false,arr);   // 卖prices[i]   
        }
    }
}
/*
 * 309. 买卖股票的最佳时机含冷冻期
给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 

示例 1:

输入: prices = [1,2,3,0,2]
输出: 3 
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
示例 2:

输入: prices = [1]
输出: 0
 */