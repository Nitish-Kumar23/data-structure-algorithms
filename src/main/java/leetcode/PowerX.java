package leetcode;

import java.util.HashMap;
import java.util.Map;

class PowerX {

    private static final Map<Integer,Double> powerVsValue = new HashMap<>();

    public static double myPow(double x, int n) {
        if(n==0 || x==1){
            return 1;
        }

        if(n<0){
            x = 1/x;
        }
        return power(x,Math.abs(n));
    }

    private static double power(double x,int n){
        if(n==1){
            powerVsValue.put(n,x);
            return x;
        }

        if(powerVsValue.containsKey(n)){
            return powerVsValue.get(n);
        }

        double val1 = power(x,(n-(n/2)));
        double val2 = power(x,n/2); 
        powerVsValue.put(n,val1*val2);

        return powerVsValue.get(n);
    }

    public static double myPowV1(double x, int n) {
        if(n==0 || x==1){
            return 1;
        }

        long absN = Math.abs((long) n);
        double result = power(x,absN);

        return n>0 ? result : 1/result;
    }

    private static double power(double x,long n){
        if(n==0){
            return 1;
        }

        double half = power(x,n/2);
        if(n%2==0){
            return half*half;
        }else{
            return x*half*half;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000,3));
    }
}