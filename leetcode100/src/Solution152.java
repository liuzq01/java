import org.junit.Test;

public class Solution152 {
    @Test
    public void test(){
        int[] nums={2,3,-2,4};
        int[] nums1={-2,0,-1};
        int[] nums2={2,5,-2,0,-1,5,9,7,-3};
        System.out.println(maxProduct(nums));
        System.out.println(maxProduct(nums1));
        System.out.println(maxProduct(nums2));
    }
    public int maxProduct(int[] nums) {
        //任取位置i，计算自此数起的所有连续位置数的乘积，取最大值。每次计算都基于前一次的结果。
        //移动i，从头到尾，取最大值。
        int[] max={nums[0]};
        for (int i = 0; i < nums.length; i++) {
            maxProduct(nums,max,i,i,1);
        }
        return max[0];
    }
    private void maxProduct(int[] nums, int[] max,int i,int j,int result) {
        if(j==nums.length) return;
        result=result*nums[j];
        if (result>max[0]) max[0]=result;
        maxProduct(nums,max,i,j+1,result);
    }
}
/*
 *  乘积最大子数组
给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 
子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
测试用例的答案是一个 32-位 整数。

输入: nums = [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。

输入: nums = [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
