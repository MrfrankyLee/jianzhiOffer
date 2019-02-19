package com.needayea.jianzhiOffer.printListNodeEndToStart;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author lixiaole
 * @date 2018/9/21 15:25
 */

/**
 * ��β��ͷ��ӡ����
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        // ����һ��stack   ������������������
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            //�Ƚ�Ԫ��ȫ����ͷ��βȫ��ѹ��ջ��
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while(!stack.empty()){
            // ��ջ  ������list����
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
