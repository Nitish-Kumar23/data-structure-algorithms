package leetcode;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }
    
    public void push(int x) {
        if(empty()){
            pushStack.push(x);
            return;
        }


        if(!pushStack.isEmpty()){
            pushStack.push(x);
            return;
        }

        transferStackValues(popStack,pushStack);
        pushStack.push(x);
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }

        if(!popStack.isEmpty()){
            return popStack.pop();
        }

        transferStackValues(pushStack,popStack);
        return popStack.pop();
    }
    
    public int peek() {
        if(empty()){
            return -1;
        }

        if(!popStack.isEmpty()){
            return popStack.peek();
        }

        transferStackValues(pushStack,popStack);
        return popStack.peek();
        
    }
    
    public boolean empty() {
        if(pushStack.isEmpty() && popStack.isEmpty()){
            return true;
        }
        return false;
    }

    private void transferStackValues(Stack<Integer> source,Stack<Integer> target){
        while(!source.isEmpty()){
            target.push(source.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */