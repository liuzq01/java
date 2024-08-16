import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class Solution102 {
    @Test
    public void test(){
        /*  二叉树的层序遍历
         * 给你二叉树的根节点root，返回其节点值的层序遍历。（即逐层地，从左到右访问所有节点）。
        输入：root = [3,9,20,null,null,15,7]
        输出：[[3],[9,20],[15,7]]

        输入：root = [1]
        输出：[[1]]

        输入：root = []
        输出：[]
         */
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);                                             TreeNode treeNode3=new TreeNode(2);
        TreeNode treeNode4=new TreeNode(3); TreeNode treeNode5=new TreeNode(4);     TreeNode treeNode6=new TreeNode(4); TreeNode treeNode7=new TreeNode(3);
        treeNode1.left=treeNode2; treeNode1.right=treeNode3;
        treeNode2.left=treeNode4; treeNode2.right=treeNode5;    treeNode3.left=treeNode6; treeNode3.right=treeNode7;
        /** ** ** * */
        TreeNode treeNode8=new TreeNode(1);
        TreeNode treeNode9=new TreeNode(2); TreeNode treeNode10=new TreeNode(2);
        TreeNode treeNode11=new TreeNode(3); TreeNode treeNode12=new TreeNode(3);
        treeNode8.left=treeNode9; treeNode8.right=treeNode10;
        treeNode9.right=treeNode11; treeNode10.right=treeNode12;
        /** ** ** * */
        TreeNode treeNode13=new TreeNode(1);

        System.out.println(levelOrder(treeNode1));
        System.out.println(levelOrder(treeNode8));
        System.out.println(levelOrder(treeNode13));
        System.out.println(levelOrder(null));
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> aLists=new ArrayList<>();
        HashMap<Integer,List<Integer>> hashMap=new HashMap<>();
        levelOrder(root,hashMap,0);
        aLists=new ArrayList<>(hashMap.values());
        return aLists;
    }
    private void levelOrder(TreeNode root,HashMap<Integer,List<Integer>>hashMap,int i) {
        // 先序遍历，把每一层的数标记上层级，结果存入HashMap<Integer i,List<Integer> root.val>
        if(root==null) return;
        hashMap.computeIfAbsent(i, k -> new ArrayList<>()).add(root.val);
        levelOrder(root.left,hashMap,i+1);
        levelOrder(root.right,hashMap,i+1);
    }
}
