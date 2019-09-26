package com.needayea.jianzhiOffer.minNumberInRotateArray;

/**
 *  旋转数组中的最小数字
 *  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *  输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *  例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *  NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author lixiaole
 * @date 2018/9/21 17:44
 */
public class Solution {
    public static int minNumberInRotateArray(int [] array) {
        if(array==null || array.length<1){
            return 0;
        }
        // 取第一个元素为最小元素
        int result = array[0] ;
        for(int i = 0 ; i<array.length-1;i++){
            // 找到第一个当前位置元素大于后面位置的元素
            if(array[i]>array[i+1]){
                // 该位置元素即为最小元素
                result = array[i+1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,1,2,3};
        int[] arr1 = {1,0,1,1,1,1};
        System.out.println(minNumberInRotateArray(arr1));
    }
}
