import org.junit.Test;

public class Solution215 {
    @Test
    public void test(){
        int[]nums={3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
        int[]nums1={3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums1, 4));
    }
    public int findKthLargest(int[] nums, int k) {
        // 快排并选择
        int[] result={0};
        findKthLargest(nums, k,0,nums.length-1,result);
        return result[0];
    }
    private void findKthLargest(int[] nums, int k, int left, int right,int[] result) {
        int pivot = (left+right)/2;
        int tempL=left, tempR=right;
        if(nums[left]>nums[pivot]) swap(nums,left,pivot);
        if(nums[right]<nums[pivot]) swap(nums,right,pivot);
        if(nums[left]>nums[pivot]) swap(nums,left,pivot);
        while (left<pivot || right>pivot) {
            while (nums[left]<=nums[pivot] && left<pivot) {
                left++;
            }
            while (nums[right]>=nums[pivot] && right>pivot) {
                right--;
            }
            if(left<pivot && right>pivot) swap(nums, left, right);
            if (left==pivot && right>pivot) {  // pivot左边的都小于它，开始向右移动pivot
                swap(nums, right, pivot);
                swap(nums, right, pivot+1);
                pivot++; left++;
            }
            if (pivot==right && left<pivot) {
                swap(nums, left, pivot);
                swap(nums, left, pivot-1);
                pivot--; right--;
            }
        }
        left=tempL; right=tempR;    // 恢复left、right
        if (nums.length-k==pivot)  result[0]=nums[pivot];
        if (nums.length-k<pivot)  findKthLargest(nums, k, left, pivot, result);
        if (nums.length-k>pivot)  findKthLargest(nums, k, pivot, right, result);
    }
    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
/*      数组中的第K个最大元素
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。

示例 1:

输入: [3,2,1,5,6,4], k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6], k = 4
输出: 4
 */
