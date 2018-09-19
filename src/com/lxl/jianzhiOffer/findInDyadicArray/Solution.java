package com.lxl.jianzhiOffer.findInDyadicArray;

/**
 * @author lixiaole
 * @date 2018/9/19 17:31
 */

/**
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 *
 * ˼·��
 *      ������ĿҪ�󿴳��������һ����������
 *      �� ÿһ�е����һ�����ڸ������  ÿһ�еĵ�һ�����ڸ�����С
 *      ���Զ����ά������к��� �дӵ�һ�п�ʼ  �������±�0   �д����һ�п�ʼ
 *
 *     �ӵ�һ�����һ�е����ֱȽ�
 *      ��������ִ��ڵ�һ�����һ������ ���һ�ж�������   ��ת���ڶ���row++
 *      ���������С�ڵ�һ�����һ������ �����һ�ж�������  ��ת�������ڶ���column--
 *
 *      ��������   ���Ҳ��� ��˵���������в�����Ŀ������ ����false ���򷵻�true
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
                // ��������   �ҵ���Ԫ�� ֱ�ӷ���
                return true;
            }
        }
        return false;
    }
}
