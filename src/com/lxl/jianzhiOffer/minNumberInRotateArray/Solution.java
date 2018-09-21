package com.lxl.jianzhiOffer.minNumberInRotateArray;

/**
 * @author lixiaole
 * @date 2018/9/21 17:44
 */

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。、
 *
 * 思考：
 *  根据题目意思：因为目标数组是一个非减排序的数组  所以只需要找到第一个自己小于其前面的元素即可
 *      若未找到   这说明第一个元素为最小的元素
 */
public class Solution {
    public static int minNumberInRotateArray(int [] array) {
        if(array==null || array.length<1){
            return 0;
        }
        int result = array[0] ;
        for(int i = 0 ; i<array.length-1;i++){
            if(array[i]>array[i+1]){
                result = array[i+1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(minNumberInRotateArray(arr));
    }
}
