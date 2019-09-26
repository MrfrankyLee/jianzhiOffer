package com.needayea.jianzhiOffer.fibonacci;

/**
 * 斐波那契数列
 * @author lixiaole
 * @date 2019-09-26
 */
public class Fibonacci {

    public static long fibonacci(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        int numberOne = 0;
        int numberTwo = 1;
        int result = 0;
        for(int i = 2 ; i<=n;i++){
            result = numberTwo + numberOne;
            numberOne = numberTwo;
            numberTwo = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(fibonacci(n));
    }
}
