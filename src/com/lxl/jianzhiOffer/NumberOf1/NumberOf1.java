package com.lxl.jianzhiOffer.NumberOf1;

/**
 * @author lixiaole
 * @date 2018/9/25
 */

/**
 * 某个数字的二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *    数字转换为二进制中后每一位不是0就是1
 *    两个操作数进行与运算,如果这一位都为1，结果才为1，否则结果为0
 *
 *    所以
 *        可以用一个数字和比他小于1的数字进行与运算
 *        从最右边开始抵消该数字的二进制最右位的1 直到所有位都为0
 *    例如：
 *        让7（111）&6（110）得到的是6（110），接着6（110）&5（101）得到4（100），
 *        接着4（100）&3（011）得到0（000），程序结束，      
 *        得到的结果就是有3个“1”
 *
 */
public class NumberOf1 {
    public static void main(String[] args) {
        NumberOf1 n = new NumberOf1();
        System.out.println(n.NumberOf1(-8));
    }
    public int NumberOf1(int number){
        int count = 0;
        while(number !=0){
            count++;
            number = number&(number-1);
        }
        return count;
    }
}
