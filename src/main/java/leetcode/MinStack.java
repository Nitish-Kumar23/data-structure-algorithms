package leetcode;

import java.io.Serializable;
import java.util.Stack;

public class MinStack implements Serializable {
    private Stack<MinNode> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        MinNode node = new MinNode(val);
        if(stack.isEmpty()){
            node.setMinValue(val);
        }else {
            node.setMinValue(Math.min(val,stack.peek().getMinValue()));
        }
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().getData();
    }

    public int getMin() {
        return stack.peek().getMinValue();
    }

    public static class MinNode{
        private Integer data;
        private Integer minValue;

        public MinNode(Integer data) {
            this.data = data;
        }

        public MinNode(Integer data, Integer minValue) {
            this.data = data;
            this.minValue = minValue;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Integer getMinValue() {
            return minValue;
        }

        public void setMinValue(Integer minValue) {
            this.minValue = minValue;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
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
