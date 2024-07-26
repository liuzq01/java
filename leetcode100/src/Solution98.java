import org.junit.Test;

public class Solution98 {
    @Test
    public void test(){
        /*      验证二叉搜索树
         * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
        有效 二叉搜索树定义如下：
        节点的左
        子树
        只包含 小于 当前节点的数。
        节点的右子树只包含 大于 当前节点的数。
        所有左子树和右子树自身必须也是二叉搜索树。
        输入：root = [2,1,3]
        输出：true
        输入：root = [5,1,4,null,null,3,6]
        输出：false
        解释：根节点的值是 5 ，但是右子节点的值是 4 。
         */
        TreeNode treeNode1=new TreeNode(2);
        TreeNode treeNode2=new TreeNode(1);
        TreeNode treeNode3=new TreeNode(3);
        treeNode1.left=treeNode2;   treeNode1.right=treeNode3;
        System.out.println(isValidBST(treeNode1));
        /*******************************************/
        TreeNode treeNode4=new TreeNode(5);
        TreeNode treeNode5=new TreeNode(4);
        TreeNode treeNode6=new TreeNode(6);
        TreeNode treeNode7=new TreeNode(1);
        TreeNode treeNode8=new TreeNode(3);
        treeNode4.left=treeNode7;   treeNode4.right=treeNode5;
        treeNode5.left=treeNode8;   treeNode5.right=treeNode6;
        System.out.println(isValidBST(treeNode4));
    }
    public boolean isValidBST(TreeNode root) {
        //二叉搜索树：左小右大，子树也是二叉搜索树（可递归）
        boolean[] result={true};
        isValidBST(root,-1,0,result);    // direction: 左-0，右-1
        return result[0];
    }
    public void isValidBST(TreeNode root,int lastValue,int direction,boolean[] result) {
        if(root==null) return;
        if (lastValue!=-1) {
            if(direction==0) {
                if(root.val >= lastValue) {
                    result[0]=false;
                    return;
                }
            }
            if(direction==1) {
                if(root.val <= lastValue) {
                    result[0]=false;
                    return;
                }
            }
        }
        isValidBST(root.left,root.val,0,result);
        isValidBST(root.right,root.val,1,result);
    }
}
