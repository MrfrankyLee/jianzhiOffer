package com.lxl.jianzhiOffer.GetLeastNumbers_Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiaole
 * @date 2018/9/26
 * @description
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 思考：  典型的topK问题
 *        先排序后取出所需的元素
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        // 快速排序
        QuickSorts(input);
        //TODO  可以根据需求选用  堆排序  或者其他更优秀的方式   这里不再列举
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(input.length <k || k<0){
            return list;
        }
        for(int i = 0 ; i<k;i++){
            list.add(input[i]);
        }
        return list;
    }

    private void QuickSorts(int[] array) {
        if(array.length <1 ||array ==null){
            return;
        }
        Sorts(array,0,array.length-1);
    }

    private void Sorts(int[] array, int left, int right) {
        if(left<right){
            int pvtion = partion(array,left,right);
            partion(array,left,pvtion-1);
            partion(array,pvtion+1,right);
        }
    }

    private int partion(int[] array, int left, int right) {
        int pvtion = array[left];
        while(left<right){
            while(left<right && array[right] > pvtion){
                right--;
            }
            if(left < right){
                array[left++] = array[right];
            }

            while (left<right && array[left] <= pvtion ){
                left++;
            }
            if(left<right){
                array[right--] = array[left];
            }
        }
        array[left] = pvtion;
        return left;
    }

    public static void main(String[] args) {
        int[] array = {4,5,1,6,2,7,3,8};
        List list = new Solution().GetLeastNumbers_Solution(array,4);
        System.out.println(list);
    }
}
