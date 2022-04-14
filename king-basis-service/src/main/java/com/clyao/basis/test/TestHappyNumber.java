package com.clyao.basis.test;

import java.util.HashSet;
import java.util.Set;

public class TestHappyNumber {

    public static void main(String[] args) {
        TestHappyNumber.isHappy(7);
    }
    
    public static boolean isHappy(int n){
        int temp = n;
        if(temp==1){
            return true;
        }else {
            Set<Integer> numSet = new HashSet<>();
            numSet.add(temp);
            while(true){
                int i=0;
                int sum = 0;
                while(temp !=0){
                    i = n%10;
                    sum += i*i;
                    temp = temp /10;
                }
                System.out.println("n:" + sum);
                if(sum == 1){
                    System.out.println(n+"为快乐数");
                    numSet.stream().forEach(o->System.out.println(o));
                    return true;
                }else {
                    if(numSet.contains(sum)){
                        System.out.println(n+"不是快乐数");
                        numSet.stream().forEach(o->System.out.println(o));
                        return false;
                    }
                    numSet.add(sum);
                    temp = sum;
                }
            }

        }
    }
}
