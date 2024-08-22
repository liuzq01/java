import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class Solution94a {
    @Test
    public void test(){
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
        System.out.println(inorderTraversal1(treeNodeRoot));
        System.out.println(preorderTraversal1(treeNodeRoot));
    }
    private List<Integer> inorderTraversal1(TreeNode root) {
        //迭代。用栈存数据，遍历二叉树。
        List<Integer> list=new ArrayList<>();
        inorderTraversal1(root,list);
        return list;
    }
    private void inorderTraversal1(TreeNode root,List<Integer> list) {
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null || !stack.isEmpty()) {
            while(root!=null) {
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            list.add(root.val);
            root=root.right;
        }
    }
    // 先序遍历
    private List<Integer> preorderTraversal1(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        preorderTraversal1( root,list);
        return list;
    }
    private void preorderTraversal1(TreeNode root,List<Integer> list) {
        Stack<TreeNode> stack=new Stack<>();
        while (root!=null || !stack.isEmpty()) {
            while (root!=null) {
                list.add(root.val);
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            root=root.right;
        }
    }
}
