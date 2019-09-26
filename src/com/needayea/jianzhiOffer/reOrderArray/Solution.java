package com.needayea.jianzhiOffer.reOrderArray;

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

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        reOrderArray(arr);
        for(int i : arr){
            System.out.print(i+"\t");
        }
    }

    public static void reOrderArray(int[] array) {
        if(array == null || array.length<1){
            return;
        }
        // 统计奇数的个数
        int count = 0;
        int start = 0;
        // 奇数的二进制最低位都是1  1&1=1
        while(start<array.length){
            if((array[start++]&1) == 1){
                count++;
            }
        }

        int[] newArray = new int[array.length];
        start = 0;
        for(int i = 0; i<array.length;i++){
            if((array[i]&1) == 1){
                newArray[start++] = array[i];
            }else {
                newArray[count++] = array[i];
            }
        }
        // 新数组的元素copy到原数组
        start = 0;
        for (int i : newArray) {
            array[start++] = i;
        }
    }
}
