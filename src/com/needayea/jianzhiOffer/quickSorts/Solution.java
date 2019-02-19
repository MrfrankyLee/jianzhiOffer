package com.needayea.jianzhiOffer.quickSorts;

/**
 * @author lixiaole
 * @date 2018/9/20 18:14
 */

/**
 * 快速排序
 * 实现思路:
 * 快速排序的算法思想其实比较简单，先找出一个数作为基准数（通常取数组最小下标或者最大下标位置的数字）。定义两个变量作为“哨兵”，然后分别从后向前，从前向后两个方向去“探测”：
 *
 *     从后向前：寻找比基准数小的数据，如果找到，停下来
 *     从前向后：寻找比基准数大的数据，如果找到，停下来
 *     如果两个方向的“探测”都找到了符合要求的数据，则交换数据，继续顺着方向寻找
 *     直到两个哨兵碰到一起，此时把相遇位置上的数据和基准数（即数组的中间位）交换数据
 *     此时，基准数左侧的数都小于等于基准数，右侧的数都大于等于基准数
 *     同样的方法去“探测”基准数左侧和右侧的数据（使用递归）
 *
 *     虽然它运行最糟糕时将达到O(n²)的时间复杂度, 但通常平均来看, 它的时间复杂为O(nlogn),
 *     快速排序似乎更偏爱乱序的数列, 越是乱序的数列, 它相比其他排序而言, 相对效率更高.
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {325,3,5,8,14,1023,8,123,5856,13215,325,612315,11,54,2,4,2415};
        Solution solution = new Solution();
        solution.quickSort(arr);
        for(int i = 0 ;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
    }

    public void quickSort(int[] arr){
        if(arr ==null ||arr.length<2){
            return;
        }
        // 定义两个哨兵  分别为 数组的最小下标  和数组的最大下标
        sort(arr,0,arr.length-1);
    }

    public void sort(int[] arr ,int left ,int right){
        if(left<right){
            // 通过基准数字将数组左右分为两个子数组
            // 数组中小于基准的数放在左边  大于基准的数字调换到右边
            // 递归子数组
            int pvtion = partion(arr,left,right);
            sort(arr,left,pvtion-1);
            sort(arr,pvtion+1,right);
        }
    }

    public int partion(int[] arr , int left , int right){
        int pvtion = arr[left]; //以数组中最左边的数字作为基准
        while (left<right){
            while (arr[right] > pvtion && left<right ){
                right--;//当右边的哨兵位置上的数字大于基准数字  哨兵左移  直达哨兵到达位于从右边开始第一个小于基准的数字
            }
            if(left<right){
                // 把最右边第一个小于基准的数字换到最左边位置
                // 因为我们以最左边的哨兵为基准 ,所以直接赋值到该哨兵位置
                arr[left++] = arr[right];//类似于 arr[left] = arr[right];left++;
            }

            while (arr[left] < pvtion && left<right){
                left++;//当左边的哨兵位置上的数字小于基准数字  哨兵右移  直达哨兵到达位于从左边开始第一个大于基准的数字
            }
            if(left<right){
                arr[right--] = arr[left];//把该大于基准的数字的换到右边
            }
        }
        arr[left] = pvtion;//把基准数字放在中间位置
        return left;// 返回中间位置的下标
    }

}
