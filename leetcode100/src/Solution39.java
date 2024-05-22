import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Solution39 {
    @Test
    public void test(){
        //组合总和
/*
        输入：candidates = [2,3,6,7], target = 7
        输出：[[2,2,3],[7]]
        解释：
        2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
        7 也是一个候选， 7 = 7 。
        仅有这两种组合。
        输入: candidates = [2,3,5], target = 8
        输出: [[2,2,2,2],[2,3,3],[3,5]]
        输入: candidates = [2], target = 1
        输出: []   
        candidates 的所有元素 互不相同； 2 <= candidates[i] <= 40    
*/
        int[] candidates={2,3,6,7};
        int target=7;
        List<List<Integer>> lists=combinationSum(candidates,target);
        for (int i = 0; i < lists.size(); i++) {
            for(Integer e:lists.get(i)) System.out.printf(e+"  ");
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //法一：  ∑(candidates[i] * k[i]) = target ,  k[i] ∈ [ 0,target/candidates[i] ], 且都是整数； n维循环。
        //法二：搜索回溯。寻找所有可行解的问题，都可以尝试用「搜索回溯」解决。
        List<List<Integer>> lists=new ArrayList<>();
        dfs(target, new ArrayList<Integer>(), 0,lists,candidates);
        return lists;
    }
    private void dfs(int target,List<Integer> combine,int idx,List<List<Integer>> lists,int[] candidates) {
        /*  递归终止条件为 target≤0 或者 candidates 数组用完。
            每次可以选择跳过第 idx 个数，即执行 dfs(target,combine,idx+1);      ①
            也可以选择使用第 idx个数，即执行 dfs(target−candidates[idx]，combine，idx)。每个数字无限制重复选取，因此搜索的下标仍为 idx。    ②
        */
        //if (target<0 ) return;
        if(idx==candidates.length) return;
        if(target==0) {
            //lists.add(combine); 
            /*
             * 在 dfs 方法中，每次递归调用 dfs 方法时，都会向 lists 中添加一个 combine 的副本，然后在后续的递归中修改这个副本。
             * 如果你直接使用 lists.add(combine);，那么 lists 中的每个元素都会引用同一个 combine 对象。这可能会导致在递归过程中修改 combine 对象时，
             * lists 中的所有元素都会受到影响，最终可能会得到错误的结果。
             */
            lists.add(new ArrayList<Integer>(combine));
            return;
        }
        dfs(target, combine, idx+1, lists, candidates); //   ①
        if (target-candidates[idx]>=0) {
            combine.add(candidates[idx]);
            dfs(target-candidates[idx], combine, idx, lists, candidates);  //   ②
                
            combine.remove(combine.size()-1);
        }
    }

}
