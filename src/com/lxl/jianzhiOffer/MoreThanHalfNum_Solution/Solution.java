package com.lxl.jianzhiOffer.MoreThanHalfNum_Solution;

import java.util.Arrays;

/**
 * @author lixiaole
 * @date 2018/9/26
 * @description
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 思考：
 *      因为这个数字出现的次数超过数组长度的一半
 *      所以将该数组排序后  中间位置的数字肯定是这个数字
 *
 * 步骤：
 *      1 对数组进行排序 找出位于最中间位置的数字、
 *      2 遍历数组统计该数字在该数组中出现的次数count
 *      3 比较count与1/2数组长度
 *
 *
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
       if(array.length<=0 ||array==null){
           return 0;
       }
       // 对数组进行排序 这里使用系统自带的排序功能 其底层根据数组长度不同可变换排序方式 且效率较高
       // 具体分析可参考 https://blog.csdn.net/timheath/article/details/68930482
       Arrays.sort(array);
       int number = array[array.length/2];
       int count = 0;
       for(int i = 0;i<array.length;i++){
           if(array[i] == number ){
               count++;
           }
       }

       return count > (array.length/2) ? number : 0;
    }

    public static void main(String[] args) {
        int[] array ={1,2,3,2,2,2,5,4,2};
        System.out.println(new Solution().MoreThanHalfNum_Solution(array));
    }
}
