import org.junit.Test;

public class Solution300 {
    @Test
    public void test(){
        int[] nums={10,9,2,5,3,7,101,18};
        int[] nums1={0,1,0,3,2,3,5};
        int[] nums2={7,7,7,7,7,7,7};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS(nums1));
        System.out.println(lengthOfLIS(nums2));
    }
    public int lengthOfLIS(int[] nums) {
        int[] arr={1};
        // 遍历数组，从每个元素开始，寻找严格递增子序列，计算长度并取最大值。
        for (int i = 0; i < nums.length; i++) {
            lengthOfLIS(nums,i,i,1,arr);    // k是严格递增子序列的长度
        }
        return arr[0];
    }
    private void lengthOfLIS(int[] nums, int i,int last,int k, int[] arr) {
        if(i>=nums.length) {
            if(k>arr[0]) arr[0]=k;
            return;
        }
        if (nums[i]>nums[last]) {
            lengthOfLIS(nums, i+1, i, k+1, arr);    //  选取nums[i]
            lengthOfLIS(nums, i+1, last, k, arr);   // 不选nums[i]
        }
        else lengthOfLIS(nums, i+1, last, k, arr);
    }
}
/*  最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
子序列
你能将算法的时间复杂度降低到 O(n log(n)) 吗?

输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

输入：nums = [0,1,0,3,2,3]
输出：4

输入：nums = [7,7,7,7,7,7,7]
输出：1
 */
