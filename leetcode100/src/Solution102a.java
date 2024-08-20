import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Solution102a {
    @Test
    public void test(){
        /*  二叉树的层序遍历
        *   真正的按层遍历二叉树，从上到下，从左往右
        */
        //
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
        System.out.println(levelOrder1(treeNode1));
        System.out.println(levelOrder1(treeNode8));
        System.out.println(levelOrder1(treeNode13));
        System.out.println(levelOrder1(null));
    }
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if(root==null) return new ArrayList<>(new ArrayList<>());
        ArrayDeque<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        TreeNode treeNode=new TreeNode();
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        while (!queue.isEmpty()) {
            int n=queue.size();
            for (int i = 0; i < n; i++) {
                treeNode=queue.poll();
                list.add(treeNode.val);
                if (treeNode.left!=null) queue.add(treeNode.left);
                if (treeNode.right!=null) queue.add(treeNode.right);
            }
            lists.add(new ArrayList<>(list));
            list.clear();
        }
        return lists;
    }
}
