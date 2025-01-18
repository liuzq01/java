import org.junit.Test;

public class Solution494 {
    @Test
    public void test(){
        int[] nums = {1,1,1,1,1};
        int target=3;
        System.out.println(findTargetSumWays(nums, target));
    }
    public int findTargetSumWays(int[] nums, int target) {
        // 遍历nums，每个元素有两种可能：乘以-1、乘以1，递归回溯，搜索所有可能的组合
        int[] count=new int[]{0};
        findTargetSumWays(nums, target,count,0);
        return count[0];
    }
    private void findTargetSumWays(int[] nums, int target, int[] count, int k) {
        if ( k==nums.length) {
            if(target==0) {
                count[0]++;
            }
            return;
        }
        findTargetSumWays(nums, target+nums[k], count, k+1);
        findTargetSumWays(nums, target-nums[k], count, k+1);
    }
}
/*
 * 494. 目标和
给你一个非负整数数组 nums 和一个整数 target 。

向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：

例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

示例 1：

输入：nums = [1,1,1,1,1], target = 3
输出：5
解释：一共有 5 种方法让最终目标和为 3 。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
示例 2：

输入：nums = [1], target = 1
输出：1
 */

