import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Solution46a {
    @Test
    public void test() {
        int[] nums = {1, 2};
        List<List<Integer>> lists = permute(nums);
        for (List<Integer> list : lists) {
            for (Integer n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(lists, new ArrayList<>(), nums);
        return lists;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            lists.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // 元素已经存在，跳过
                tempList.add(nums[i]);
                backtrack(lists, tempList, nums);
                tempList.remove(tempList.size() - 1); // 回溯
            }
        }
    }
}
