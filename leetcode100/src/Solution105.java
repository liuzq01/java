import org.junit.Test;

public class Solution105 {
    @Test
    public void test(){
    /*
    *给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， 
    inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点 
    输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    输出: [3,9,20,null,null,15,7]

    输入: preorder = [-1], inorder = [-1]
    输出: [-1]    
    preorder 和 inorder 均 无重复 元素
    inorder 均出现在 preorder
    */
    int[] preorder={3,9,20,15,7};
    int[] inorder={9,3,15,20,7};
    TreeNode root=buildTree(preorder, inorder);
    System.out.println(root);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=new TreeNode();
        buildTree(preorder, inorder,root,0,0,preorder.length-1,0,0,inorder.length-1);
        return root;
    }
    private void buildTree(int[] preorder, int[] inorder,TreeNode root,int preLeft,int preMiddle,int preRight,int inLeft,int inMiddle,int inRight) {
        // 前序遍历：{根节点，[左子树的前序遍历结果]，[右子树的前序遍历结果]}，左右子树可继续以此细分下去. [preleft],(preleft,premiddle],(premiddle,preright]
        // 中序遍历：{[左子树的前序遍历结果]，根节点，[右子树的前序遍历结果]}，左右子树可继续以此细分下去. [inleft,inmiddle),[inmiddle],(inmiddle,inright]
        // 从前序遍历确定「根节点」，再从中序遍历确定左右子树的长度
        if(inLeft==inMiddle-1) {
            root=new TreeNode(inMiddle);
            root.left=new TreeNode(inLeft);
            return;
        } 
        if(inRight==inMiddle+1) {
            root=new TreeNode(inMiddle);
            root.right=new TreeNode(inRight);
            return;
        } 
        root.val=preorder[preLeft];
        for (int i = inLeft; i <= inRight; i++) {
            if(inorder[i]==root.val) {
                inMiddle=i;
                preMiddle=inMiddle-inLeft+preLeft;
                preRight=inRight-inMiddle+preMiddle;
            }
        }
        buildTree(preorder, inorder,new TreeNode(),preLeft+1,0,preMiddle,inLeft,0,inMiddle-1);  //左子树
        buildTree(preorder, inorder,new TreeNode(),preMiddle+1,0,preRight,inMiddle+1,0,inRight);  //右子树
    }
}
