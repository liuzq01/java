import org.junit.Test;

public class Solution416 {
    @Test
    public void test(){
        int[] nums={1,5,11,5};
        int[] nums1={1,2,3,5};
        System.out.println(canPartition(nums));
        System.out.println(canPartition(nums1));
    }
    public boolean canPartition(int[] nums) {
        // 求出所有元素的和S。S是奇数，false; S是偶数，取半 S/2，在nums中找数，使得它们的和为 S/2 。
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum=sum+nums[i];
        }
        if (sum%2!=0) {
            return false;
        }
        boolean[] arr={false};
        canPartition(nums,sum/2,0,arr);
        return arr[0];
    }
    private void canPartition(int[] nums, int sum, int i, boolean[] arr) {
        if (sum<0 || i==nums.length) {
            return;
        }
        if (sum==0) {
            arr[0]=true;
            return;
        }
        canPartition(nums,sum-nums[i],i++,arr);
        canPartition(nums,sum,i++,arr);
    }
}
/*
 * 416. 分割等和子集
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

示例 1：

输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：

输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。
 

提示：

1 <= nums.length <= 200
1 <= nums[i] <= 100
 */

