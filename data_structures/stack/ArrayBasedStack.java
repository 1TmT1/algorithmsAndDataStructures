package data_structures.stack;

import java.util.EmptyStackException;

public class ArrayBasedStack {
    private static final int MAX = 100;
    private int top;
    private int[] arr;

    public ArrayBasedStack() {
        top = -1;
        arr = new int[MAX];
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return arr[top];
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return arr[top--];
    }

    public void push(int value) {
        if (top >= (MAX - 1)) {
            throw new StackOverflowError();
        }

        arr[++top] = value;
    }

    public void print() {
        for (int i = top; i > 0; i--) {
            System.out.print(arr[i] + ", ");
        }
        
        System.out.println(arr[0]);
    }

    public static void main(String[] args) {
        ArrayBasedStack stack = new ArrayBasedStack();

        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(10);

        stack.print();

        System.out.println(stack.peek());
        stack.pop();
        
        stack.print();
    }
}
