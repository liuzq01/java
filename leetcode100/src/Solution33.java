import org.junit.Test;

public class Solution33 {
    @Test
    public void test(){
        //搜索旋转排序数组
/*
        输入：nums = [4,5,6,7,0,1,2], target = 0
        输出：4
        输入：nums = [4,5,6,7,0,1,2], target = 3
        输出：-1
        输入：nums = [1], target = 0
        输出：-1
        nums 按升序排列，每个值都互不相同，时间复杂度为 O(log n)
*/
        int[] nums={4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }
    public int search(int[] nums, int target) {

    }
}
