import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class Solution15 {
    @Test
    //三数之和
    public void test(){
        //输入：nums = [-1,0,1,2,-1,-4]
        //输出：[[-1,-1,2],[-1,0,1]]
        int[]nums={-1,0,1,2,-1,-4};
        List<List<Integer>> list=threeSum(nums);
        for(List<Integer> list2:list)  {
            for(Integer integer:list2){
                System.out.printf("%d ",integer);
            }
            System.out.println();
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        //遍历数组nums，捉对儿存入hashMap
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < nums.length-1; i++) {
            for (int k = i+1; k < nums.length; k++) {
                        hashMap.put(nums[k], nums[i]);  //相同的元素会覆盖；(key,value) --> (y,x)
            }
        }
        //遍历数组nums，寻找三数之和为零的组合
        List<List<Integer>> list=new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            for (Integer key : hashMap.keySet()) {
                if(nums[i]+key+hashMap.get(key)==0) {
                    Integer[] arr={nums[i],key,hashMap.get(key)};
                    List<Integer> list3=Arrays.asList(arr);
                    list.add(list3);
                }
            }
        }
        //给list排序、去重
        if(!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Collections.sort(list.get(i));
            }
            list=list.stream().distinct().collect(Collectors.toList());
        }
        return list;
    }
}
