package com.needayea.jianzhiOffer.mergearray;

/**
 * 合并两个增序数组
 * @author lixiaole
 * @date 2019-09-24
 */
public class MegerArray {

    public int[] meger2Array(int[] array1,int[] array2){
        if(array1 == null || array1.length<1){
            return array2==null? new int[0]:array2;
        }
        if(array2==null || array2.length<1){
            return array1;
        }
        int count = array1.length + array2.length;
        int result[] = new int[count];
        int i = 0 ,j=0 ,k=0;
        // 先合并最短数组
        while(i<array1.length && j<array2.length){
            if(array1[i]<array2[j]){
                result[k++] = array1[i++];
            }else {
                result[k++] = array2[j++];
            }
        }
       // 再合并长数组剩余部分
       while (k<count){
           result[k++] = i<array1.length?array1[i++]:array2[j++];
       }
       return result;
    }
}
