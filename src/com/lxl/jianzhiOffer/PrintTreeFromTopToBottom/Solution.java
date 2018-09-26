package com.lxl.jianzhiOffer.PrintTreeFromTopToBottom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lixiaole
 * @date 2018/9/26
 * @description
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 思考：
 *      根据题目要求:  同一层节点从左到右打印 所以首先可以想到的是用一个临时容器来存节点
 *      当遍历到某一节点的时候   将其左右子节点  保存到临时容器  然后按照先入先出的顺序从该临时容器中取出元素
 *      根据先入先出的特性  可以确定临时容器用队列(Queue)替代
 * 步骤：
 *      1.定义一个临时队列
 *      2.将根节点存入到临时队列
 *      3.当队列不为空的时候 取出头部元素  并将其左 右 子节点 分别存入队列
 *      4 将队列头部元素的数值添加到list集合中
 *      5 循环 直到队列中的元素为空
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
     ArrayList<Integer> arrayList = new ArrayList<Integer>();
     if(root ==null){
         return arrayList;
     }
     // LinkedList 实现了Deque接口 而Deque接口的父接口为Queue  因此选择用LinkedList实现
     Queue<TreeNode> queue = new LinkedList<TreeNode>();
     queue.offer(root);
     while(!queue.isEmpty()){
         TreeNode pNode = queue.poll();
         if(pNode.left!= null){
             queue.offer(pNode.left);
         }
         if(pNode.right!= null){
             queue.offer(pNode.right);
         }
         arrayList.add(pNode.val);
     }
     return arrayList;
    }
}
class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}