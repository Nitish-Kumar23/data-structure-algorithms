package CrackingTheCodingInterview;

import stack.Stack;

import java.util.EmptyStackException;

public class StackUsingArrayV1 {

    private static int[] arr = new int[10];

    public int top1=-1;

    public int top2=arr.length;

    public class Stack1 implements Stack<Integer>{

        public Stack1() {
        }

        @Override
        public void push(Integer element) {
            if(top1>=top2){
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

    public class Stack2 implements Stack<Integer>{

        public Stack2() {
        }

        @Override
        public void push(Integer element) {
            if(top2<=top1){
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

    public static void main(String[] args) {
        Stack1 stack1 = new StackUsingArrayV1().new Stack1();
        Stack2 stack2 = new StackUsingArrayV1().new Stack2();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.println(stack1.peek());
//        stack1.pop();
        System.out.println(stack1.peek());
        stack2.push(5);
        stack2.push(7);
        stack2.push(8);
        System.out.println(stack2.size());
        stack2.pop();
        System.out.println(stack2.peek());
        stack1.push(4);
        stack1.push(5);
        System.out.println(stack1.peek());
        System.out.println(stack1.size());
        stack1.push(6);
        System.out.println(stack1.size());
    }

}
