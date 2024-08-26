import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Solution114 {
    @Test
    public void test(){
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
    TreeNode treeNode13=new TreeNode(0);
        flatten(treeNode1);
        check(treeNode1);

        flatten(treeNode8);
        check(treeNode8);

        flatten(treeNode13);
        check(treeNode13);

        flatten(null);
        check(null);
    }
            
    public void flatten(TreeNode root) {
        if(root==null) return;
        List<TreeNode> list=new ArrayList<>();
        flatten(root,list);
        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).right=list.get(i+1);
        }
        //root=list.get(0);   // java传递参数，传递的都是值的副本。此赋值有效范围仅限于当前函数内部。赋值无效，改变位于此地址上的数据有效。
        root.val=list.get(0).val;
        root.left=null;
        root.right=list.get(0).right;
    }
    private void flatten(TreeNode root,List<TreeNode> list) {
        if(root==null) return;
        TreeNode node=new TreeNode(root.val);
        list.add(node);
        flatten(root.left,list);
        flatten(root.right,list);
    }
    private void check(TreeNode root){
        List<Integer> list=new ArrayList<>();
        while (root!=null) {
            if(root.left==null) list.add(root.val);
            root=root.right;
        }
        System.out.println(list);
    }
    /*  二叉树展开为链表
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
        展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
        展开后的单链表应该与二叉树 「先序遍历」 顺序相同。
        输入：root = [1,2,5,3,4,null,6]
        输出：[1,null,2,null,3,null,4,null,5,null,6]

        输入：root = []
        输出：[]

        输入：root = [0]
        输出：[0]
        进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
     */
    /****** treeNode1 ******
     *  1
       / \
      2   2
     / \ / \
    3  4 4  3
    ****** treeNode8 ******
        1
       / \
      2   2
       \   \
        3   3
     */
}
