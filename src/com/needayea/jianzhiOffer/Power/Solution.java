package com.needayea.jianzhiOffer.Power;

/**
 * @author lixiaole
 * @date 2018/9/25
 */

//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
public class Solution{
    public static void main(String[] args) throws Exception {
        double a = Power2(-2,2);
        System.out.println(a);
    }
    public static double Power(double base, int exponent) throws Exception {
        double result = 1;
        if(base == 0) return 0;
        if(exponent == 0) return 1;
        int n = exponent > 0 ? exponent : -exponent;
        result = Power(base , n>>1);
        result *= result;
        if((n&1) ==1){
            result *= base;
        }
        return exponent > 0 ? result : 1/result;
    }

    public static double Power2(double base, int exponent){
        if(base == 0){
            return 0;
        }
        double result = 1.0;
        int length = exponent < 0 ? -exponent: exponent;
        for(int i = 1; i<= length ;i++){
            result *= base;
        }

        return result = exponent < 0 ? 1/result: result ;
    }
}
