package com.lxl.jianzhiOffer.reverseList;

/**
 * @author lixiaole
 * @date 2018/9/19 17:08
 */

/**
 * 链表反转
 * 例如:
 * 反转前:1->2->3->4->5->6
 * 反转后:6->5->4->3->2->1
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

    // 链表反转
    public static ListNode ReverseList(ListNode head){
        if(head == null || head.next ==null){
            return head;
        }
        // 反转后新的头节点
        ListNode newHead = null;
        // 前驱节点
        ListNode preNode = null;
        // 当前节点设为临时节点
        ListNode tempNode = head;
        while (tempNode != null){
            // 后继节点(这里用来保存当前节点的下一个节点的值)
            ListNode nextNode = tempNode.next;
            // 如果最后一个节点的next为空   则该节点为反转后得到的头节点
            if(nextNode == null){
                newHead = tempNode;
            }
            // 前驱节点为当前节点的下一个节点
            tempNode.next = preNode;
            // 将当前节点设置为自己本身的前驱节点
            preNode = tempNode;
            // 自己本身为自己的后继节点
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
