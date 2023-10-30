package Leetcode;

import java.io.Serializable;
import java.util.Stack;

public class EvaluateRPN implements Serializable {

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String s : tokens){
            if(s.equalsIgnoreCase("+")) {
                int sum = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                stack.push(String.valueOf(sum));
            }

            else if(s.equalsIgnoreCase("/")){
                int divisor = Integer.parseInt(stack.pop());
                int dividend = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(dividend/divisor));
            }
            else if(s.equalsIgnoreCase("*")){
                int mul = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                stack.push(String.valueOf(mul));
            }
           else if(s.equalsIgnoreCase("-")){
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a-b));
            }
            else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
