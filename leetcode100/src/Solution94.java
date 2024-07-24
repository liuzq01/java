import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class Solution94 {
    @Test
    public void test(){
/*  二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
        输入：root = [1,null,2,3]
        输出：[1,3,2]

        输入：root = []
        输出：[]

        输入：root = [1]
        输出：[1]
        进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
        TreeNode treeNodeRoot=new TreeNode(1);
        TreeNode treeNode1=new TreeNode(2);
        TreeNode treeNode2=new TreeNode(3);
        TreeNode treeNode3=new TreeNode(4);
        TreeNode treeNode4=new TreeNode(5);
        TreeNode treeNode5=new TreeNode(6);
        TreeNode treeNode6=new TreeNode(7);
        TreeNode treeNode7=new TreeNode(8);
        treeNodeRoot.left=treeNode1;    treeNodeRoot.right=treeNode2;
        treeNode1.left=treeNode3;       treeNode2.right=treeNode4;
        treeNode3.right=treeNode5;
        treeNode5.left=treeNode6;       treeNode5.right=treeNode7;
        System.out.println(inorderTraversal(treeNodeRoot));
        System.out.println(preorderTraversal(treeNodeRoot));
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        inorderTraversal( root,list);
        return list;
    }
    private void inorderTraversal(TreeNode root,List<Integer> list) {
        if(root.left!=null) inorderTraversal(root.left,list);
        list.add(root.val);
        if(root.right!=null) inorderTraversal(root.right,list);
    }
    /*
                  1
                /   \
               2      3 
             /         \
            4           5
             \ 
              6
             /  \
            7    8
    先序：1 2 4 6 7 8 3 5
    中序：4 7 6 8 2 1 3 5
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        preorderTraversal( root,list);
        return list;
    }
    private void preorderTraversal(TreeNode root,List<Integer> list) {
        list.add(root.val);
        if(root.left!=null) preorderTraversal(root.left,list);
        if(root.right!=null) preorderTraversal(root.right,list);
    }
}
