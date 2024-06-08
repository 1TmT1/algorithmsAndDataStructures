package data_structures.queue;

import java.util.NoSuchElementException;

public class LinkedListBasedQueue {

    private ListNode front;
    private ListNode rear;
    private int length;

    private class ListNode {
        private int value;
        private ListNode next;
        
        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedListBasedQueue() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return;
        }

        ListNode current = front;

        System.out.print("|Front = " + current.value);
        current = current.next;

        if (current != null) {
            System.out.print(" -> ");
        }

        while (current != null && current.next != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        
        if (current != null) {
            System.out.println(current.value + " = Rear|");
        } else {
            System.out.println(" = Rear|");
        }
        
        // System.out.println("null");
    }

    public void enqueue(int value) {
        ListNode temp = new ListNode(value);
        
        if (isEmpty()) {
            front = temp;
        } else {
            rear.next = temp;
        }

        rear = temp;
        length++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
            // return 0; // -1
        }

        int deleted = front.value;
        
        // First Method

        // if (length == 1) {
        //     front = null;
        //     rear = null;
        //     length--;
        //     return deleted;
        // } else {
        //     front = front.next;
        //     length--;
        //     return deleted;
        // }

        // Second Method

        front = front.next;
        if (front == null) {
            rear = null;
        }
        length--;
        return deleted;
    }

    public int front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        }

        return front.value;
    }

    public int rear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        }

        return rear.value;
    }

    public static void main(String[] args) {
        LinkedListBasedQueue queue = new LinkedListBasedQueue();

        queue.enqueue(1);
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(10);

        queue.print();

        System.out.println(queue.dequeue());
        queue.print();

        System.out.println("Front - " + queue.front());
        System.out.println("Rear - " + queue.rear());
    }
}
