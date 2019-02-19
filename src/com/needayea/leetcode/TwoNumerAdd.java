package com.needayea.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

public class TwoNumerAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 预防空指针异常
        if(l1 == null ){
            l1 = new ListNode(0);
        }
        if(l2 == null ){
            l2 = new ListNode(0);
        }

        if(l1.next == null && l2.next == null){
            int value = l1.val + l2.val;
            if(value > 9 ){
                ListNode node = new ListNode(value%10); // 第二位 根据原题目意思  大于10向后进一位
                node.next = new ListNode(value/10);  //第一位
                return node;
            }else {
                return new ListNode(value);
            }
        }else {
            int value = l1.val + l2.val;
            if(value > 9 ){
                value = 10 -value;
                if(l1.next!= null ) l1.next.val++;
                else if(l2.next!= null ) l2.next.val++;
                // 没有第三种情况
            }
            ListNode node = new ListNode(value);
            node.next = addTwoNumbers(l1.next,l2.next);
            return node;
        }
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
