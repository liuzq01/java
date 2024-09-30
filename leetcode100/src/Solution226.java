import java.util.ArrayList;

import org.junit.Test;

public class Solution226 {
    @Test
    public void test(){
        TreeNode root=new TreeNode(4);
        TreeNode n1=new TreeNode(2);        TreeNode n2=new TreeNode(7);
        TreeNode n3=new TreeNode(1);TreeNode n4=new TreeNode(3);TreeNode n5=new TreeNode(6);TreeNode n6=new TreeNode(9);
        root.left=n1;   root.right=n2;
        n1.left=n3; n1.right=n4;    n2.left=n5; n2.right=n6;
        ArrayList<Integer> list=new ArrayList<>();
        preOrder(root, list);
        System.out.println(list);
        /****************************************/
        invertTree(root);
        list.clear();
        preOrder(root, list);
        System.out.println(list);
    }
    public TreeNode invertTree(TreeNode root) {
        TreeNode temp=null;
        invertTree(root,temp);
        return root;
    }
    private void invertTree(TreeNode root, TreeNode temp) {
        if(root==null) return;
        temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left,temp);
        invertTree(root.right,temp);
    }
    private void preOrder(TreeNode root,ArrayList<Integer> list){
        //先序遍历
        if(root==null) return;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
/*      翻转二叉树
给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]

输入：root = [2,1,3]
输出：[2,3,1]

输入：root = []
输出：[]
 */
/*
 *    4
     / \
    2   7
   / \ / \
  1  3 6  9

      4
     / \
    7   2
   / \ / \
  9  6 3  1
 */
