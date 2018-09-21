package com.lxl.jianzhiOffer.printListNodeEndToStart;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author lixiaole
 * @date 2018/9/21 15:25
 */

/**
 * 从尾到头打印链表
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        // 创建一个stack   利用其先入后出的性质
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            //先将元素全部从头到尾全部压入栈中
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while(!stack.empty()){
            // 弹栈  并加入list集合
            list.add(stack.pop());
        }
        return list;
    }
}

class ListNode{
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
