package com.needayea.jianzhiOffer.rebuildtree;

/**
 * 通过 二叉树的前序和中序遍历结果 重构建二叉树
 * @author lixiaole
 * @date 2019-09-25
 */
public class RebuildTreeByArray {
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0 || pre.length != in.length){
            return null;
        }
        TreeNode  root = new TreeNode(pre[0]);
        int i = 0;
        while(in[i] != root.val){
            i++;
        }
        // 左子树前序遍历结果
        int[] preLeft = new int[i];
        // 左子树中序遍历结果
        int[] inLeft = new int[i];

        // 右子树前序
        int[] preRight = new int[in.length-i-1];
        // 右子树中序
        int[] inRight = new int[in.length-i-1];

        int j = 0;
        while(j<in.length){
            if(j<i){
                preLeft[j] = pre[j+1];
                inLeft[j] = in[j];
            }else if(j>i){
                preRight[j-i-1] = pre[j];
                inRight[j-i-1] = in[j];
            }
            j++;
        }

        root.left = reConstructBinaryTree(preLeft,inLeft);
        root.right = reConstructBinaryTree(preRight,inRight);
        return root;
    }

    //后序遍历
    public static void last(TreeNode tr) {
        if(tr == null) {
            return ;
        }

        last(tr.left);
        last(tr.right);
        System.out.print(tr.val +" ");
    }

    public static void main(String[] args) {
        int[] a = {1,2,4,7,3,5,6,8};
        int[] b = {4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(a,b);
        last(root);
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
