import java.util.Arrays;

import org.junit.Test;

public class Solution238 {
    @Test
    public void test(){
        int[] nums={1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        int[] nums1={-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums1)));
    }
    public int[] productExceptSelf(int[] nums) {
        int l=nums.length;
        int[] left=new int[l];
        int[] right=new int[l];
        left[0]=1; right[0]=1;
        for (int i = 1; i < l; i++) {
            left[i]=left[i-1]*nums[i-1];
        }
        for (int i = 1; i < l; i++) {
            right[i]=right[i-1]*nums[l-i];
        }
        int[] result=new int[l];
        for (int i = 0; i < l; i++) {
            result[i]=left[i]*right[l-i-1];
        }
        return result;
    }
/*  除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。） 

输入: nums = [1,2,3,4]
输出: [24,12,8,6]

输入: nums = [-1,1,0,-3,3]
输出: [0,0,9,0,0]
保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 */
}
