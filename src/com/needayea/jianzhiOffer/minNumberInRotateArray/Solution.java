package com.needayea.jianzhiOffer.minNumberInRotateArray;

/**
 * @author lixiaole
 * @date 2018/9/21 17:44
 */

/**
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0����
 *
 * ˼����
 *  ������Ŀ��˼����ΪĿ��������һ���Ǽ����������  ����ֻ��Ҫ�ҵ���һ���Լ�С����ǰ���Ԫ�ؼ���
 *      ��δ�ҵ�   ��˵����һ��Ԫ��Ϊ��С��Ԫ��
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
