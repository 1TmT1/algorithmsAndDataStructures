package data_structures.queue;

import java.util.NoSuchElementException;

public class ArrayBasedQueue {
    private int front;
    private int rear;
    private int MAX;
    private int[] queue;

    public ArrayBasedQueue(int max) {
        front = rear = 0;
        MAX = max;
        queue = new int[MAX];
    }

    public int length() {
        return rear - front;
    }

    public boolean isEmpty() {
        // return queue.length == 0;
        // return rear == 0;
        return length() == 0;
    }

    public boolean isFull() {
        return MAX == rear;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Full Queue");
            return;
        }

        queue[rear] = value;
        rear++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        }

        int deleted = queue[front];
        front++;
        return deleted;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return;
        }

        System.out.print("|Front = ");
        
        for (int i = front; i < rear - 1; i++) {
            System.out.print(queue[i] + " -> ");
        }

        System.out.println(queue[rear - 1] + " = Rear|");
    }

    public int front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        }

        return queue[front];
    }

    public int rear() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return queue[rear - 1];
    }

    public static void main(String[] args) {
        ArrayBasedQueue queue = new ArrayBasedQueue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.print();

        System.out.println(queue.dequeue());

        queue.print();

        System.out.println("Front - " + queue.front());
        System.out.println("Rear - " + queue.rear());
    }
}
