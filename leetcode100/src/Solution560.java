import org.junit.Test;

public class Solution560 {
    @Test
    public void test(){
        int nums[]={1,1,1}, k=2;
        //int nums[]={1,2,3}, k=3;
        System.out.println(subarraySum(nums, k));
    }
    public int subarraySum(int[] nums, int k) {
        int count=0;
        // 子数组的长度是l，范围：[i,i+l)
        for (int l = 1; l <= nums.length; l++) {
            for (int i = 0; i <= nums.length-l; i++) {
                int sum=0;
                for (int j = i; j <i+l ; j++) {
                    sum=sum+nums[j];
                }
                if (k==sum) {
                    count++;
                }
            }
        }
        return count;
    }
}
/*
 * 560. 和为 K 的子数组
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。

子数组是数组中元素的【连续】非空序列。

示例 1：

输入：nums = [1,1,1], k = 2
输出：2
示例 2：

输入：nums = [1,2,3], k = 3
输出：2

 */

