package com.lxl.jianzhiOffer.reconstructBinayTree;

/**
 * @author lixiaole
 * @date 2018/9/21 15:37
 */

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例
 * 如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 思考：
 *      二叉树
 *          前序遍历特点   根左右
 *          中序遍历特点   左跟右
 *      1 根节点在前序遍历中为第一个数字  即下标为0的数字
 *      2 找到跟节点的值既可以找到根节点在中序遍历中的位置
 *      3 通过根节点在中序遍历中的位置获得左右子树的长度
 *      4 根据其长度构建左右子树的前后序遍历数组
 *      5 递归
 */
public class solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
       if(pre.length <=0 || in.length<=0 || pre.length!= in.length)
           return null;
       TreeNode root = new TreeNode(pre[0]);
       int i = 0;
       // 获取 根节点在中序遍历中的位置   从而将其分为左右两个子树
       while(in[i] != root.val){
           i++;
       }
       // 构建左子树  前中序遍历
       int[] leftPre = new int[i];
       int[] leftIn  = new int[i];

       // 构建右子数前中序
        // 长度为in.length-i-1 是不包含root节点
       int[] rightPre = new int[in.length-i-1];
       int[] rightIn = new int[in.length-i-1];

       for(int j = 0 ; j<in.length;j++){
           if(j<i){
               leftPre[j] = pre[j+1];// 前序遍历的第一个节点为根节点 跳过
               leftIn[j] = in[j];
           }else if(j>i){
               rightPre[j-i-1] = pre[j];
               rightIn[j-i-1] = in[j];
           }
       }
       // 构建左子树
       root.left = reConstructBinaryTree(leftPre,leftIn);
       // 构建右子树
       root.right = reConstructBinaryTree(rightPre,rightIn);
       return root;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
