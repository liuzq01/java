import org.junit.Test;

public class Solution34 {
    @Test
    public void test(){
        //在排序数组中查找元素的第一个和最后一个位置
/*
        输入：nums = [5,7,7,8,8,10], target = 8
        输出：[3,4]
        输入：nums = [5,7,7,8,8,10], target = 6
        输出：[-1,-1]
        输入：nums = [], target = 0
        输出：[-1,-1]        
        nums正序，时间复杂度为 O(log n)
*/
        //int[] nums={5,7,7,8,8,10};
        //int[] nums={};
        //int[] nums={6};
        //int[] nums={6,8};
        int[] nums={8,8,8,8};
        int[] n=searchRange(nums, 8);
        System.out.printf("[ "+n[0]+" , "+n[1]+" ]");
    }
/*
    设结果是[l,r],分类讨论：
        (1) medium<l，则递归二分找 medium ∈ [l,r];
        (2) l<=medium<=r，则找l、r;
        (3) r<medium，找 medium ∈ [l,r];
        (4) 结果可能是[-1,-1]
*/
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        else return searchRange(nums, target,0,nums.length-1);
    }
    private int[] searchRange(int[] nums, int target,int left,int right) {
        if(left==right && nums[left]!=target) return new int[]{-1,-1};  //  (4)
        int medium=(left+right)/2;
        if(nums[medium]<target) return searchRange(nums, target,medium+1,right);    //  (1)
        if(nums[medium]==target) {      //  (2)
            return searchRange1(nums, target,left,right,medium,0,0,right);
        }
        else return searchRange(nums, target,left,medium);      //  (3)
    }
    private int[] searchRange1(int[] nums, int target,int left,int right,int medium,int l,int r, int r0) {
        // (5) 在[left,medium]找左端点l 
        // (6) 在[medium,right]找右端点r
        if(left<medium && medium<=right) right=medium;   //  第一次
        if (right<=medium) {              //  (5)
            int m=(left+right)/2;
            if(left==m) {                //此时数组只剩2个数，nums[left], nums[right]
                if(nums[left]==target) l=left;
                else l=right;
            }
            else{
                if(nums[m]!=target) return searchRange1(nums, target, m, right, medium,l,r,r0);
                else return searchRange1(nums, target, left, m, medium,l,r,r0);     //
            }
        }
        if(left<=medium ) {      //  第一次
            left=medium;
            right=r0;   //此时right已经改变，不是最初的那个值，需要重置
        }
        if (left>=medium) {     //  (6)
            int m=(left+right)/2;   
            if(left==m) {
                if(nums[right]==target) r=right;
                else r=left;
            }
            else{
                if(nums[m]!=target) return searchRange1(nums, target, left, m, medium,l,r,r0);
                else return searchRange1(nums, target, m, right, medium,l,r,r0);
            }
        }
        return new int[]{l,r};
    }
}
