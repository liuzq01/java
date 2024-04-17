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
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //  ∑(candidates[i] * k[i]) = target ,  k[i]∈[0,target/candidates[i]], 且都是整数； n维循环。

    }

}
