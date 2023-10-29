package stack;

public interface Stack<T> {

    /**
     * add element to the top of stack
     *
     * @param element
     */
    void push(T element);

    /**
     * Return & remove top of the stack element
     *
     * EmptyStackException if stack is empty
     *
     * @return
     */
    T pop();

    /**
     *
     * Return if stack is empty or not
     *
     * @return
     */
    boolean isEmpty();

    /**
     * Returns top of stack element
     *
     * @return
     */
    T peek();

    /**
     * Returns the size of the stack
     *
     * @return
     */
    Integer size();

}
