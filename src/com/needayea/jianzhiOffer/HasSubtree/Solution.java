package com.needayea.jianzhiOffer.HasSubtree;

/**
 * @author lixiaole
 * @date 2018/9/25
 */

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null ||(root1==null && root2!=null)) return false;
        boolean result = false;

        if(root1.val == root2.val){
            result = match(root1,root2);
        }

        if(result){
            return result;
        }

        return HasSubtree(root1.left,root2) ||HasSubtree(root1.right,root2);
    }

    private  boolean match(TreeNode root1,TreeNode root2){
        if(root2==null) return true;
        if(root1==null && root2!=null) return false;

        if(root1.val == root2.val){
            return match(root1.left, root2.left) && match(root1.right, root2.right);
        }

        return false;
    }
}

class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
