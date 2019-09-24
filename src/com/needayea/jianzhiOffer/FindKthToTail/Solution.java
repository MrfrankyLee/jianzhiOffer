package com.needayea.jianzhiOffer.FindKthToTail;

/**
 * @author lixiaole
 * @date 2018/9/25
 */

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 思考：
 *     1.定义两个快慢指针分别为  pre 和 last
 *     2.快指针先走k-1步（因为倒数第一个节点即为最后一个节点  k=1时不需要快指针先走）
 *     3.快慢指针一起走   当快指针到达最后一个节点时    慢指针刚好位于倒数第k个节点
 */
public class Solution {
    public ListNode findKthToTail(ListNode head,int k) {
        if(head == null  || k <=0){
            return null;
        }
        // 先走的快指针
        ListNode fast = head;
        //后走的慢指针
        ListNode slow = head;
        // 快指针先走k-1个节点
        for(int i = 0; i<k-1;i++){
            if(fast.next != null){
                fast = fast.next;
            }else {
                return null;
            }
        }

        //两个指针一起走  快指针先到达最后一个节点  此时慢指针所在位置即为倒数第k个节点
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

class ListNode{
    int val;
    ListNode next =null;

    public ListNode(int val) {
        this.val = val;
    }
}
