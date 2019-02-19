package com.needayea.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length;i++){
            // 若果不存在  返回true
            boolean result = set.add(nums[i]);
            // 若存在   返回false
            if(!result){
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if(nums.length<=1){
            return false;
        }
        // 对数组进行排序   如果有重复数字 其必然是相邻的元素
        Arrays.sort(nums);
        int value = nums[1];
        if(nums[0] == value){
            return true;
        }
        for(int i =2 ;i<nums.length;i++){
            if(nums[i]== value){
                return true;
            }
            value = nums[i];
        }
        return false;
    }
}
