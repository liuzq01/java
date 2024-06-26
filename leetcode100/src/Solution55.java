import org.junit.Test;

public class Solution55 {
    @Test
    public void test(){
        /*  跳跃游戏
        输入：nums = [2,3,1,1,4]
        输出：true
        解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
        输入：nums = [3,2,1,0,4]
        输出：false
        解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。 
        */
        //int[] nums={2,3,1,1,4};
        int[] nums={3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    public boolean canJump(int[] nums) {
        boolean[] flag={false};
        canJump(nums,0,flag);   //boolean 是基本数据类型，传入方法后，值不会改变
        return flag[0];
    }
    public void canJump(int[] nums,int n,boolean[]flag) {
        //  ∑{ n + [ 0,nums[n] ] } == nums.length-1;
        //回溯
        if(n==nums.length-1) {
            flag[0]=true;
            return;
        }
        if(n>nums.length-1 || nums[n]==0) return;
        for (int i = 1; i <= nums[n]; i++) {
            n=n+i;
            canJump(nums,n,flag);
            n=n-i;
        }
    }
}
