package com.needayea.jianzhiOffer.HasSubtree;

/**
 * @author lixiaole
 * @date 2018/9/25
 */

import com.needayea.jianzhiOffer.util.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution {

    public boolean hasSubTreeNode(TreeNode root1 , TreeNode root2){
        if(root1 == null || root2 == null){
            return false;
        }
        boolean flag = false;

        if(root1.val == root2.val){
            return match(root1,root2);
        }
        return flag ? flag : hasSubTreeNode(root1.left,root2) || hasSubTreeNode(root1.right,root2);
    }

    public boolean match(TreeNode root1 , TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }

        if(root1.val == root2.val){
            return match(root1.left,root2.left) && match(root1.right,root2.right);
        }

        return false;
    }
}