import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Solution78 {
    /*      子集
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
        子集（幂集）。解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

        输入：nums = [1,2,3]
        输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

        输入：nums = [0]
        输出：[[],[0]]
     */
    @Test
    public void test(){
        int[] nums={1,2,3};
        List<List<Integer>> lists=subsets(nums);
        System.out.println(lists);
    }
    public List<List<Integer>> subsets(int[] nums) {
        // 关键在于 m选n的所有组合：C(m,n)
        // 已经实现了全排列：A(m,m), Solution46.java
        if(nums.length==0) return new ArrayList<>(new ArrayList<>());
        List<List<Integer>> combine=new ArrayList<>();
        combine.add(new ArrayList<>(new ArrayList<>()));
        List<Integer> aList=new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            subsets(nums,i,combine,0,aList);
        }
        return combine;
    }
    public void subsets(int[] nums,int n,List<List<Integer>> combine,int k,List<Integer> aList) {
        //  m选n的所有组合：C(m,n)
        if(n==0) {      //  n是剩余可选的个数
            combine.add(new ArrayList<>(aList));
            return;
        }
        for (int i = k; i < nums.length; i++) {
            aList.add(nums[i]);
            subsets(nums,n-1,combine,i+1,aList);    //  ①
            if(aList.size()>=1) aList.remove(aList.size()-1);  
        }
    }
}
/* i
 * 0         1   1   1   1
 * 1         2   2   2   2
 * 2         3   3   3   3
 * 3         4   4   4   4
 * 
 * 递归层数:  0   1   2   3
 * ***************************************
 * 对称：全排列产生的子集 [m,n],必定有[n,m]与之对应，只生成[m,n]即可。
 * 随着递归层数的增加，i的值增大，即可不重不漏。    ①
 */
