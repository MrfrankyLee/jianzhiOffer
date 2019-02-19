package com.needayea.jianzhiOffer.Permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author lixiaole
 * @date 2018/9/26
 * @description
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 思考：
 *     1.先将字符串str转换为char[] 数组类型
 *     2.定义一个set集合用来存储调换顺序后的字符串(set集合自带去重功能)
 *     3.以chs数组中的第一个为基准   调换后面两个顺序    得到 abc  acd
 *     4。同理 以递归的方式 进行调换
 */
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str == null || str.length()<=0){
            return list;
        }
        HashSet<String> set = new HashSet<>();
        function(set,str.toCharArray(),0);
        list.addAll(set);
        Collections.sort(list);
        return list;
    }
    private void function(HashSet<String> set,char[] chs ,int k){
        if(k==chs.length-1){
            set.add(String.valueOf(chs));
        }

        for(int i = k ; i<chs.length;i++){
            if(i!=k){
                swap(chs,i,k);
            }
            function(set,chs,k+1);
            if(i!=k){
                swap(chs,i,k);
            }
        }
    }

    private void swap(char[] chs, int i, int k) {
        char temp = chs[i];
        chs[i] = chs[k];
        chs[k] = temp;
    }


    public static void main(String[] args) {
        List<String> list =  new Solution().Permutation("abc");
        System.out.println(list.toString());
    }
}
