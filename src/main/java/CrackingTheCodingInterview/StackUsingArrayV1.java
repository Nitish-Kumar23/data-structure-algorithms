package CrackingTheCodingInterview;

import stack.Stack;

import java.util.EmptyStackException;

public class StackUsingArrayV1 {

    private static final int[] arr = new int[10];

    private static int top1=-1;

    private static int top2=arr.length;

    public static class Stack1 implements Stack<Integer>{

        public Stack1() {
        }

        @Override
        public void push(Integer element) {
            if(top1==top2-1){
                throw new StackOverflowError();
            }
            arr[++top1]=element;
        }

        @Override
        public Integer pop() {
            if(isEmpty()){
                throw new EmptyStackException();
            }
            int element = arr[top1];
            top1--;
            return element;
        }

        @Override
        public boolean isEmpty() {
            return top1==-1;
        }

        @Override
        public Integer peek() {
            return arr[top1];
        }

        @Override
        public Integer size() {
            return top1+1;
        }
    }

    public static class Stack2 implements Stack<Integer>{

        public Stack2() {
        }

        @Override
        public void push(Integer element) {
            if(top1==top2-1){
                throw new StackOverflowError();
            }
            arr[--top2] = element;
        }

        @Override
        public Integer pop() {
            if(isEmpty()){
                throw new EmptyStackException();
            }
            int element = arr[top2];
            top2--;
            return element;
        }

        @Override
        public boolean isEmpty() {
            return top2==arr.length+1;
        }

        @Override
        public Integer peek() {
            return arr[top2];
        }

        @Override
        public Integer size() {
            return arr.length-top2;
        }
    }

    public int getTop1() {
        return top1;
    }

    public void setTop1(int top1) {
        this.top1 = top1;
    }

    public int getTop2() {
        return top2;
    }

    public void setTop2(int top2) {
        this.top2 = top2;
    }

    public static void main(String[] args) {
        Stack1 stack1 = new StackUsingArrayV1.Stack1();
        Stack2 stack2 = new StackUsingArrayV1.Stack2();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.println(stack1.size());
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(1);
        System.out.println(stack2.size());
    }

}
