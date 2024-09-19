package testpackage;

import models.IStack;
import models.ListIStack;

public class StackTest {

    public static void main(String[] args) {
        IStack<Integer> IStack = new ListIStack<>();
        IStack.push(5);
        IStack.push(6);
        IStack.push(7);
        IStack.push(8);
        System.out.println(IStack.size());
        System.out.println(IStack.pop());
        System.out.println(IStack.size());
        System.out.println(IStack.isEmpty());
        System.out.println(IStack.peek());


        IStack<String> stringIStack = new ListIStack<>();
        stringIStack.push("5");
        stringIStack.push("6");
        stringIStack.push("7");
        stringIStack.push("8");
        System.out.println(stringIStack.size());
        System.out.println(stringIStack.pop());
        System.out.println(stringIStack.size());
        System.out.println(stringIStack.isEmpty());
        System.out.println(stringIStack.peek());
    }

}
