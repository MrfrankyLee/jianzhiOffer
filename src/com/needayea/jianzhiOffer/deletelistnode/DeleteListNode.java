package com.needayea.jianzhiOffer.deletelistnode;

import com.needayea.jianzhiOffer.util.ListNode;

/**
 * 在o(1)时间内删除链表节点
 *
 * @author lixiaole
 * @date 2019-09-26
 */
public class DeleteListNode {

    public void deleteNode(ListNode head , ListNode toBeDeleted){
        if(head  == null || toBeDeleted == null){
            return;
        }
        // 如果被删除节点的下一个节点不为空 直接把被删除节点的下一个节点 复制到被删除节点
        if(toBeDeleted.next != null){
            ListNode next = toBeDeleted.next;
            toBeDeleted.val = next.val;
            toBeDeleted.next = next;
            // 如果链表就一个节点 还是当前要删除的节点  则将链表置空
        }else if(head == toBeDeleted){
            head = null;
        }else {
            // 如果当前要删除的节点为最后一个节点 则遍历到倒数第二个节点 将其next节点置空
            ListNode pNode = head;
            while(pNode.next != toBeDeleted){
                pNode = pNode.next;
            }
            pNode.next = null;
        }

    }

}
