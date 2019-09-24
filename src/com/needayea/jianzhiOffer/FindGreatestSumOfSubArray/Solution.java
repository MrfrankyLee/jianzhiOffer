package com.needayea.jianzhiOffer.FindGreatestSumOfSubArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lixiaole
 * @date 2018/9/26
 * @description
 * 连续子数组的最大和
 * 原题: HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
 *      在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 *      但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 *      例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 *      给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *思考：
 *      如果能够使用一个临时容器来分别保存它们之间的和  然后排序将这个容器中的最大值找出来即可完美解决
 *
 *步骤：
 *      1.定义一个list集合  用来存放这些元素累加的和
 *      2.遍历数组  将其每一项累加的和 分别存储到集合中
 *          双重遍历  第一层表示从哪个元素开始累加
 *          第二层 从这个位置开始累加到什么地方结束
 *      3 对集合排序取出集合中的最后一个元素  即最大值
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
      if(array.length<1){
          return 0;
      }
      List<Integer> list = new ArrayList<Integer>();
        // i用来控制累加的起始位置
      for(int i = 0 ; i<array.length;i++){
          int sum = 0;
          // 从下标为0的位置开始 累加  i每增加1 开始位置后退一位
          for(int j = i;j<array.length;j++){
              sum +=array[j];
              //每加一个元素  就将它的值存到list集合
              list.add(sum);
          }
      }
      // 对list集合中的元素进行排序  最后一个元素就是累加最大的值
      Collections.sort(list);
      return list.get(list.size()-1);
    }
}
