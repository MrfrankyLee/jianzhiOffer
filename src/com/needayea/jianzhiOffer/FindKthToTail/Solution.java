package com.needayea.jianzhiOffer.FindKthToTail;

/**
 * @author lixiaole
 * @date 2018/9/25
 */

import com.needayea.jianzhiOffer.util.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 思考：
 *     1.定义两个快慢指针分别为  pre 和 last
 *     2.快指针先走k-1步（因为倒数第一个节点即为最后一个节点  k=1时不需要快指针先走）
 *     3.快慢指针一起走   当快指针到达最后一个节点时    慢指针刚好位于倒数第k个节点
 */
public class Solution {
    public ListNode findKthNode(ListNode head , int k){
        if(head == null || k <1){
            return head;
        }
        ListNode pFastNode = head;
        ListNode pSlowNode = head;
        int count = 1;
        while (count < k){
            if(pFastNode.next == null){
                return null;
            }
            pFastNode = pFastNode.next;
            count++;
        }
        while(pFastNode.next != null){
            pFastNode = pFastNode.next;
            pSlowNode = pSlowNode.next;
        }
        return pSlowNode;
    }
}