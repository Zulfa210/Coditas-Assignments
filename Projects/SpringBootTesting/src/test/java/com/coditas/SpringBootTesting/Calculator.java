package com.coditas.SpringBootTesting;

/**
 * @author Zulfa Attar
 */
public class Calculator {
    public int doSum(int a, int b, int c){
        return a+b+c;
    }
    public int doProduct(int a, int b, int c){
        return a*b*c;
    }

    public Boolean isEqual(int a, int b){
        return a == b;
    }

}
