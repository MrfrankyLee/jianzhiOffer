package com.lxl.jianzhiOffer.reverseList;

/**
 * @author lixiaole
 * @date 2018/9/19 17:08
 */

/**
 * ����ת
 * ����:1->2->3->4->5->6
 * ��ת��:6->5->4->3->2->1
 */
public class Solution {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode result = ReverseList(listNode1);
        System.out.println(result);
    }

    // ����ת
    public static ListNode ReverseList(ListNode head){
        if(head == null || head.next ==null){
            return head;
        }
        // ��ת���µ�ͷ�ڵ�
        ListNode newHead = null;
        // ǰ���ڵ�
        ListNode preNode = null;
        // ��ǰ�ڵ���Ϊ��ʱ�ڵ�
        ListNode tempNode = head;
        while (tempNode != null){
            // ��̽ڵ�(�����������浱ǰ�ڵ����һ���ڵ��ֵ)
            ListNode nextNode = tempNode.next;
            // ������һ���ڵ��nextΪ��   ��ýڵ�Ϊ��ת��õ���ͷ�ڵ�
            if(nextNode == null){
                newHead = tempNode;
            }
            // ǰ���ڵ�Ϊ��ǰ�ڵ����һ���ڵ�
            tempNode.next = preNode;
            // ����ǰ�ڵ�����Ϊ�Լ������ǰ���ڵ�
            preNode = tempNode;
            // �Լ�����Ϊ�Լ��ĺ�̽ڵ�
            tempNode = nextNode;
        }
        return newHead;
    }
}

class ListNode{
    int value;
    ListNode next = null;

    public ListNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
