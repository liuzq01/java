import org.junit.Test;

public class Solution198 {
    @Test
    public void test(){
        int[] nums={2,7,9,3,1};
        System.out.println(rob(nums));
        int[] nums1={2,7,9,3,4,1,1,2};
        System.out.println(rob(nums1));

    }
    public int rob(int[] nums) {
        //选第一个数（或第二个数）开始累加，每次可以跳2步或3步。跳4步时，加上跳2步的数更大，回到跳2步。
        int sum1=0, sum2=0, max[]={0};
        rob(nums,sum1,0,max);
        sum1=max[0];
        rob(nums,sum2,1,max);
        sum2=max[0];
        return Math.max(sum1, sum2);
    }
    private void rob(int[] nums, int sum,int i,int[] max) {
        if(i>=nums.length) {
            if(sum> max[0]) max[0]=sum;
            return;
        }
        sum=sum+nums[i];
        rob(nums,sum,i+2,max);
        rob(nums,sum,i+3,max);
    }

}
/*      打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
