package data_structures.list;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode {
        private int value;
        private ListNode next;
        private ListNode previous;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
                // or head == null
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void print() {
        if (head == null) {
            return;
        }

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public void printReverse() {
        if (tail == null) {
            return;
        }

        ListNode temp = tail;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.previous;
        }

        System.out.println("null");
    }

    public void addToEnd(int value) {
        ListNode newNode = new ListNode(value);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        newNode.previous = tail;
        tail = newNode;
        length++;
    }

    public void addToStart(int value) {
        ListNode newNode = new ListNode(value);

        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }

        newNode.next = head;
        head = newNode;
        length++;
    }

    public ListNode deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty List");
        }

        // 5 | 10 --> null
        ListNode temp = head;
        
        if (head == tail) {
            tail = null;
        } else {
            head.next.previous = null;
        }

        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty List");
        }

        // 5 | 10 --> null
        ListNode temp = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.previous.next = null;
        }

        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.addToEnd(1);
        dll.addToEnd(4);
        dll.addToEnd(7);
        dll.addToEnd(13);
        dll.addToEnd(21);
        

        dll.print();
        dll.printReverse();

        System.out.println();

        dll.addToStart(0);
        dll.print();

        final String deleteMsg = "Deleted node value: ";
        ListNode deleted = dll.deleteFirst();
        System.out.println(deleteMsg + deleted.value);

        deleted = dll.deleteLast();
        System.out.println(deleteMsg + deleted.value);

        dll.print();
    }
}
