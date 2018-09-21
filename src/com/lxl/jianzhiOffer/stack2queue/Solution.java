package com.lxl.jianzhiOffer.stack2queue;

/**
 * @author lixiaole
 * @date 2018/9/21 17:28
 */

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 思考 ：
 *      栈的特点:先进后出
 *      队列的特点:先进后出
 *
 *    所以：
 *      入队列的时候  全部压入到stack1中
 *      出队列的时候  如果stack1 不为空  则把其依次弹出到stack2  取stack2的栈顶元素即为队列的第一个元素
 *
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        // stack2 中的栈顶元素就是第一个出队列的元素
        int result = stack2.pop();
        // 取得第一个出列的元素后 将stack2中剩余的元素全部压入stack1
        // 防止stack1继续压入元素  此时stack2并没有空 出队时继续压入到stack2 则出队的元素并不是最先进入的元素 打乱队列顺序
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}
