package models;

import java.util.EmptyStackException;

public class ListIStack<T> implements IStack<T> {

    public static class StackNode<T> {
        private T data;

        private StackNode<T> next;

        public StackNode(T data){
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public StackNode<T> getNext() {
            return next;
        }

        public void setNext(StackNode<T> next) {
            this.next = next;
        }
    }

    private StackNode<T> top;
    int size = 0;

    @Override
    public void push(T element) {
        StackNode<T> node = new StackNode<>(element);
        node.setNext(top);
        top = node;
        size++;
    }

    @Override
    public T pop() {
        if(top==null){
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return top==null;
    }

    @Override
    public T peek() {
        if(top==null){
            throw new EmptyStackException();
        }
        return top.data;
    }

    @Override
    public Integer size() {
        return size;
    }

}
