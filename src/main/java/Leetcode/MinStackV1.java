package Leetcode;

import java.io.Serializable;
import java.util.Stack;

public class MinStackV1 implements Serializable {

    private Stack<Integer> minStack;

    private Stack<Integer> dataStack;

    public MinStackV1() {
        minStack = new Stack<>();
        dataStack = new Stack<>();
    }

    public void push(int val) {
        if(minStack.isEmpty()){
            minStack.push(val);
        }else {
            if(val<=minStack.peek()){
                minStack.push(val);
            }
        }
        dataStack.push(val);
    }

    public void pop() {
        if(minStack.peek().equals(dataStack.peek())){
            minStack.pop();
        }
        dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
