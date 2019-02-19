package com.needayea.jianzhiOffer.VerifySquenceOfBST;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiaole
 * @date 2018/9/26
 * @description
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *  思考 ：  根据题目要求  满足二叉搜索树的后序遍历
 *         二叉搜索树的后序遍历的特点是   根节点位于下标最大的元素位置
 *         且左子树所有节点的值都小于根节点  右子树所有节点的值都大于根节点
 *         所以  只要有左子树或者右子树中其中任意一个元素的值大于(相对于左子树而言)或者小于(相对于右子树而言)根节点都不满足
 *  步骤：
 *      1.找到右子树起始节点在数组中的位置 该位置前面的所有节点都属于左子树的节点
 *      2.遍历右子树  只要其中任何一个数字小于根节点  就返回false
 *      3.递归遍历左右子树的序列
 */
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence ==null || sequence.length<=0){
            return false;
        }
        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }

    private boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
        if(start<=end){
            return true;
        }
        //找到右子树起始节点在数组中的位置 该位置前面的所有节点都属于左子树的节点
        for(;start<end;start++){
            if(sequence[start] > sequence[end]){
                break;
            }
        }
        //遍历右子树  只要其中任何一个数字小于根节点  就返回false
        for(int i = start ;i<end;i++){
            if(sequence[i] < sequence[end]){
                return false;
            }
        }
        //递归遍历左右子树的序列
        return VerifySquenceOfBST(sequence,0,start-1) && VerifySquenceOfBST(sequence,start,end-1);
    }
}
