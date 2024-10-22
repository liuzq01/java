import java.util.Arrays;
import org.junit.Test; 

public class Solution283 {
    @Test
    public void test(){
        int[] nums={0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void moveZeroes(int[] nums) {
        // 倒序遍历数组，不为0，跳过；是0，移动到末尾。
        if(nums.length<=1) return;
        for (int i = nums.length-2; i >=0; i--) {   // 不论最后一个数是否为0，都不需要从它开始检查
            if (nums[i]==0) {
                for (int j = i; j < nums.length-1; j++) {
                    swap(nums,j,j+1);
                }
            }
        }
    }
    private void swap(int[] nums, int j, int i) {
        int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }

}
/*  移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意 ，必须在不复制数组的情况下原地对数组进行操作。
进阶：你能尽量减少完成的操作次数吗？

输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]

输入: nums = [0]
输出: [0]
 */

