package com.lxl.jianzhiOffer.IsPopOrder;

/**
 * @author lixiaole
 * @date 2018/9/26
 * @description
 *      输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 *      例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 *      但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * 思考：
 *      1.定义一个stack为临时变量
 *      2.将pushA 中的元素一一压入栈中
 *      3.压栈的过程中取栈顶元素 和 popA数组的首个元素进行比较
 *          如果不相等   继续将pushA中压栈
 *          如果相等  将栈顶元素弹出
 *      4.继续比较popA的下一个元素和此时的栈顶元素
 *          重复步骤3  直到压入栈中的元素全部弹出
 *      5 判断栈是否已经弹空   若空则说明popA 是pushA的弹出顺序
 */

import java.util.Stack;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    if(pushA.length<=0 || popA.length<=0 || pushA.length!=popA.length)return false;
    Stack<Integer> stack = new Stack<Integer>();
    int index = 0;
    for(int i = 0 ;i< pushA.length ;i++){
        stack.push(pushA[i]);
        while(!stack.empty()&&(stack.peek() == popA[index])){
            stack.pop();
            index++;
        }
    }
    return stack.empty();
    }
}
