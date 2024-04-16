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
        //int[] nums={1};
        System.out.println(search(nums, 0));
    }
    public int search(int[] nums, int target) {
/*
        从中间将nums切开，分成两块，按切点位置分类讨论：
        切点在最大值左侧：一块正序的 (可二分查找)+ 一块与nums形状相似的（可递归）；     ①
        切点在最大值：两块都是正序的；                                              ②
        切点在最大值右侧侧：一块与nums形状相似的 + 一块正序的；                      ③
*/      
        if(nums.length==0) return -1;
        return search(nums, target,0,nums.length-1);
    }
    private int search(int[] nums,int target,int left,int right){
        if(left==right){
            if(nums[left]==target) return left;
            else return -1;
        }
        int medium=(left+right)/2;           // nums分成两部分：[left,medium]、[medium+1,right]
        if(nums[left]<=nums[medium] && nums[medium+1]>=nums[right]) {      //  ①
            int i=binarySearch(nums, target, left, medium);
            if(i!=-1) return i;
            else return search(nums, target,medium+1,right);
        }
        if(nums[left]<=nums[medium] && nums[medium+1]<=nums[right]){      //  ②
            int i=binarySearch(nums, target, left, medium);
            if(i!=-1) return i;
            int j=binarySearch(nums, target, medium+1,right);
            return j;
        }
        else {      //  ③
            int j=binarySearch(nums, target, medium+1,right);
            if(j!=-1) return j;
            else return search(nums, target,left,medium);
        }
    }
    private int binarySearch(int[] nums,int target,int left,int right){
        if(target<nums[left] || nums[right]<target) return -1;
        if(left==right){
            if(target==nums[left]) return left;
            else return -1;
        }
        int medium=(left+right)/2;
        if(nums[medium]==target) return medium;
        if(target<nums[medium]) return binarySearch(nums, target, left, medium);
        else return binarySearch(nums, target, medium+1,right);
    }
}
