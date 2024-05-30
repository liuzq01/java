import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class Solution46 {
    @Test
    public void test(){
        /* 全排列
         * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
        示例 1：
        输入：nums = [1,2,3]
        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        示例 2：
        输入：nums = [0,1]
        输出：[[0,1],[1,0]]
        
        示例 3：
        输入：nums = [1]
        输出：[[1]]
         */
        int[] nums={1,2,3};
        //int[] nums={4};
        List<List<Integer>> lists=permute(nums);
        for (List<Integer> list : lists) {
            for (Integer n:list) {
                System.out.printf(n+" ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int l=nums.length;
        List<List<Integer>> lists=new LinkedList<>();
        return permute(nums,l,lists);
    }
    public List<List<Integer>> permute(int[] nums,int l,List<List<Integer>> lists) {
        if (l==0) return new LinkedList<>(new LinkedList<>());
        if(l==1) {
            lists.add(new LinkedList<>(List.of(nums[0])));
        }
        if (l>=2) {
            int[] nums1=new int[l-1];
            for (int i = 0; i < l-1; i++) {
                nums1[i]=nums[i];
            }
            List<List<Integer>> lists1=permute(nums1, l-1, lists);
            List<Integer> list2=lists1.get(0);
            while (list2.size()==l-1) {
                for (int i = 0; i < l; i++) {
                    list2.add(i,nums[l-1]);
                    lists1.add(new LinkedList<>(list2));    //lists1.add(list2),多个元素引用同一个 list2 对象。修改list2，所有相关元素受影响。
                    list2.remove(i);
                }
                lists1.remove(0);
                list2=lists1.get(0);
            }
            //lists.clear();
            //lists.addAll(lists1);
        }
        return lists;
    }
}