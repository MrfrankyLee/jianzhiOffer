package com.needayea.jianzhiOffer.print_treenode_from_top_to_bottom;

import com.needayea.jianzhiOffer.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lixiaole
 * @date 2019-10-08
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
public class PrintFromTopToBottom {

    public List<Integer> PrintFromTopToBottom(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
            result.add(node.val);
        }

        return result;
    }
}
