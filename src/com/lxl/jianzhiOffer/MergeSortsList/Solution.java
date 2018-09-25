package com.lxl.jianzhiOffer.MergeSortsList;

/**
 * @author lixiaole
 * @date 2018/9/25
 */
/**
 *输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 思考:
 *      如果list1为空  直接返回list2
 *      如果list2为空  直接返回list1
 *
 *      如果都不为空，比较list.val 和 list2.val的大小
 *      如果list1.val < list2.val   递归遍历list1.next 和list2
 *      如果list1.val > list2.val   递归遍历list1 和list2.next
 */

public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 ==null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode MergeList = null;
        if(list1.val <list2.val){
            MergeList =list1;
            MergeList.next = Merge(list1.next,list2);
        }else {
            MergeList = list2;
            MergeList.next = Merge(list1,list2.next);
        }
        return MergeList;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}