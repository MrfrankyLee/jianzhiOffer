package com.lxl.jianzhiOffer.findInDyadicArray;

/**
 * @author lixiaole
 * @date 2018/9/19 17:31
 */

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 思路：
 *      根据题目要求看出该数组的一个明显特征
 *      即 每一行的最后一个数在该行最大  每一列的第一个数在该列最小
 *      所以定义二维数组的行和列 行从第一行开始  即数组下标0   列从最后一列开始
 *
 *     从第一行最后一列的数字比较
 *      如果该数字大于第一行最后一个数字 则第一行都不满足   跳转到第二行row++
 *      如果该数字小于第一行最后一个数字 则最后一列都不满足  跳转到倒数第二列column--
 *
 *      依次类推   若找不到 怎说明该数组中不存在目标数字 返回false 否则返回true
 *
 */

public class Solution {

    public static void main(String[] args) {
        int[][] array ={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        boolean result = Find(10,array);
        System.out.println(result);
    }

    public static boolean Find(int target, int [][] array) {
        int row =  0;
        int column = array[0].length-1;
        while (column>=0 && row<array.length ) {
            if(array[row][column] > target){
                column--;
            }else if(array[row][column] <target){
                row++;
            }else {
                // 满足条件  找到该元素 直接返回
                return true;
            }
        }
        return false;
    }
}
