package leetcode;

import java.io.Serializable;
import java.util.Stack;

public class ValidParenthesis implements Serializable {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(isOpeningBrackets(ch)){
                stack.push(ch);
            }
            else {
                if(stack.isEmpty()){
                    return false;
                }
                char lastBracket = stack.peek();
                if(lastBracket=='[' && ch==']' || lastBracket=='(' && ch==')' || lastBracket=='{' && ch=='}'){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }

       return stack.isEmpty();
    }

    private static boolean isOpeningBrackets(char c) {
        // '(', ')', '{', '}', '[' and ']'
        if(c=='(' || c=='{' || c=='['){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("{}"));
    }
}
