package com.needayea.jianzhiOffer.TreeMirror;

/**
 * @author lixiaole
 * @date 2018/9/26
 */

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 *
 *   思考：
 *      1.如果这棵树为空  或者 只有一个根节点  则直接返回
 *      2.如果不满足1则
 *          定义一个临时变量   左右子树进行交换
 *      3.递归 左右子树
 */
public class Solution {
    public void Mirror(TreeNode root){
        if(root == null || (root.left ==null && root.right ==null)) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null){
            Mirror(root.left);
        }
        if(root.right != null){
            Mirror(root.right);
        }
    }
}

class TreeNode{
    int val ;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
