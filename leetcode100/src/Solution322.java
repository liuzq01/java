import org.junit.Test;

public class Solution322 {
    @Test
    public void test(){
        int[] coins={1, 2, 5}; int amount=11;
        System.out.println(coinChange(coins, amount));
        int[] coins1={2}; int amount1=3;
        System.out.println(coinChange(coins1, amount1));
        int[] coins2={1}; int amount2=0;
        System.out.println(coinChange(coins2, amount2));
    }
    public int coinChange(int[] coins, int amount) {
        int[] arr={coins.length+1};
        coinChange(coins, amount,arr,0);
        if(arr[0]==coins.length+1) return -1;
        return arr[0];
    }
    private void coinChange(int[] coins, int amount, int[] arr, int sum) {
        if(amount<0) return;
        if(amount==0) {
            if(arr[0]>sum) arr[0]=sum;
        }
        for (int j = 0; j < coins.length; j++) {
            coinChange(coins, amount-coins[j],arr,sum+1);
        }
    }
}
/*
 * 322. 零钱兑换
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

你可以认为每种硬币的数量是无限的。

 

示例 1：

输入：coins = [1, 2, 5], amount = 11
输出：3 
解释：11 = 5 + 5 + 1
示例 2：

输入：coins = [2], amount = 3
输出：-1
示例 3：

输入：coins = [1], amount = 0
输出：0     (输出：-1)

 */
