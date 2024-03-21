import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

public class Solution1 {
    @Test
    public void test(){
        int[]nums={2,4,8,16,32,64,128,256,512,1024};
        int target=80;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        //System.out.println(Arrays.toString(twoSum1(nums, target)));   //方法二：用hashmap
    }
    public int[] twoSum(int[]nums,int target){
        for (int i = 0; i < nums.length-1; i++) {       ////时间复杂度：O(N^2)，空间复杂度：O(1)
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target) return new int[]{i,j};
            }
        }
        return new int[0];
    }
    public int[] twoSum1(int[]nums,int target){
            //方法二：用hashmap
        HashMap<Integer,Integer> hashmap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {     
            hashmap.put(target-nums[i],nums[i]);    //values都在数组中，检验某个key是否在nums数组中即可
        }
        for (int i = 0; i < nums.length; i++) {     //时间复杂度：O(N)，空间复杂度：O(N)
            if(hashmap.containsKey(nums[i])) {
                for (int j = 0; j < nums.length; j++) {
                    if(nums[j]==hashmap.get(nums[i])) return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
}
