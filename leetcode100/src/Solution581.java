import org.junit.Test;

public class Solution581 {
    @Test
    public void test(){
        int[] nums={2,6,4,8,10,9,15};
        //int[] nums={1,2,3,4};
        //int[] nums={5};
        System.out.println(findUnsortedSubarray(nums));
    }
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length==1) {
            return 0;
        }
        // 对nums升序排序，得array，两数组对比，分别找到从左边开始不相同的首元素、从右边开始不相同的首元素即可
        int[] array=new int[nums.length];
        for (int i = 0; i < array.length; i++) {
            array[i]=nums[i];
        }
        //冒泡排序
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j]>array[j+1]) {
                    swap(array, i, j);
                }
            }
        }
        int left=0, right=0;
        for (int i = 0; i < array.length; i++) {
            if (nums[i]!=array[i]) {
                left=i;
                break;
            }
        }
        for (int i = array.length-1; i >=0; i--) {
            if (nums[i]!=array[i]) {
                right=i;
                break;
            }
        }
        if (left==right) {
            return 0;
        }
        return right-left+1;
    }
    private void swap(int[] array, int i, int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
/*
 * 581. 最短无序连续子数组
给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

请你找出符合题意的 最短 子数组，并输出它的长度。

示例 1：

输入：nums = [2,6,4,8,10,9,15]
输出：5
解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
示例 2：

输入：nums = [1,2,3,4]
输出：0
示例 3：

输入：nums = [1]
输出：0

进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？

*/

