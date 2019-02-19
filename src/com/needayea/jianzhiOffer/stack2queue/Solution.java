package com.needayea.jianzhiOffer.stack2queue;

/**
 * @author lixiaole
 * @date 2018/9/21 17:28
 */

import java.util.Stack;

/**
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 *
 * ˼�� ��
 *      ջ���ص�:�Ƚ����
 *      ���е��ص�:�Ƚ����
 *
 *    ���ԣ�
 *      ����е�ʱ��  ȫ��ѹ�뵽stack1��
 *      �����е�ʱ��  ���stack1 ��Ϊ��  ��������ε�����stack2  ȡstack2��ջ��Ԫ�ؼ�Ϊ���еĵ�һ��Ԫ��
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
        // stack2 �е�ջ��Ԫ�ؾ��ǵ�һ�������е�Ԫ��
        int result = stack2.pop();
        // ȡ�õ�һ�����е�Ԫ�غ� ��stack2��ʣ���Ԫ��ȫ��ѹ��stack1
        // ��ֹstack1����ѹ��Ԫ��  ��ʱstack2��û�п� ����ʱ����ѹ�뵽stack2 ����ӵ�Ԫ�ز��������Ƚ����Ԫ�� ���Ҷ���˳��
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}
