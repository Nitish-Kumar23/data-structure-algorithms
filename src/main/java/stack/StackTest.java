package stack;

public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new ListStack<>();
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());


        Stack<String> stringStack = new ListStack<>();
        stringStack.push("5");
        stringStack.push("6");
        stringStack.push("7");
        stringStack.push("8");
        System.out.println(stringStack.size());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.size());
        System.out.println(stringStack.isEmpty());
        System.out.println(stringStack.peek());
    }

}
