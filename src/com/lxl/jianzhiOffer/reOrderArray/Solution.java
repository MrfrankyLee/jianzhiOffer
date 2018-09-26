package com.lxl.jianzhiOffer.reOrderArray;

/**
 * @author lixiaole
 * @date 2018/9/26
 * @description
 * 调整数组顺序使奇数位于偶数前面
 * 思考：
 *      1 遍历数组   统计数组中奇数元素的个数count
 *      2 创建一个新的临时数组
 *      3 遍历原数组  并进行判断
 *              奇数元素从下标为0开始 存放到新的数组
 *              偶数元素从count下标开始 存放到新数组
 *      4 将新数组的元素复制到原数组中
 */
public class Solution {
    public void reOrderArray(int[] array){
        if(array==null || array.length<1) return;
        int start = 0;
        int count = 0; // 用来统计奇数的个数
        for(int i = 0 ;i<array.length;i++){
            if((array[i]&1)==1){
                count++;
            }
        }

        int[] newArray = new int[array.length];
        for(int i = 0 ;i<array.length ;i++){
            if((array[i]&1)==1){
                newArray[start++] = array[i];
            }else {
                newArray[count++] = array[i];
            }
        }

        for(int i = 0 ;i<array.length;i++){
            array[i] = newArray[i];
        }
    }
}
