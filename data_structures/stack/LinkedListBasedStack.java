package data_structures.stack;

import java.util.EmptyStackException;

public class LinkedListBasedStack {
    private ListNode top;
    private int length;

    private class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedListBasedStack() {
        top = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(int value) {
        ListNode temp = new ListNode(value);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        int deleted = top.value;
        top = top.next;
        length--;
        return deleted;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.value;
    }

    public static void main(String[] args) {
        LinkedListBasedStack stack = new LinkedListBasedStack();

        stack.push(1);
        stack.push(15);
        stack.push(50);
        stack.push(100);

        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}
