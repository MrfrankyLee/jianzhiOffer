package com.lxl.jianzhiOffer.NumberOf1Between1AndN;

/**
 * @author lixiaole
 * @date 2018/9/27
 * @Description
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * 思考：将每一个数字都转换成字符类型的数组
 *      遍历数组中的每一个元素  如果这个元素为1 则count++;
 *
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().NumberOf1Between1AndN_Solution(10));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        while(n>0){
            String value = String.valueOf(n);
            char[] chs = value.toCharArray();
            for(char ch : chs){
                if(ch == '1'){
                    count++;
                }
            }
            n--;
        }
        return count;
    }

    public int NumberOf1Between1AndN_Solution2(int n){
        int count = 0;
        int i = 1;
        for (i = 1; i <= n; i *= 10) {
            int a = n / i, b = n % i;
            count = count + (a + 8) / 10 * i;
            if (a % 10 == 1) {
                count += b + 1;
            }
        }
        return count;
    }
}