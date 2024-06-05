package data_structures.list;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    private class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public CircularSinglyLinkedList() {
        last = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
               // last == null
        return length == 0;
    }

    public void createCircularSinglyLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(15);
        ListNode fourth = new ListNode(19);

        first.next = second;
        length++;
        second.next = third;
        length++;
        third.next = fourth;
        length++;
        fourth.next = first;
        length++;

        last = fourth;
    }

    public void print() {
        if (isEmpty()) {
            return;
        }

        ListNode first = last.next;
        while (first != last) {
            System.out.print(first.value + " -> ");
            first = first.next;
        }

        System.out.println(first.value);
    }

    public void addToStart(int value) {
        ListNode newNode = new ListNode(value);

        if (isEmpty()) {
            last = newNode;
        } else {
            newNode.next = last.next; 
        }

        last.next = newNode;
        length++;
    }

    public void addToEnd(int value) {
        ListNode newNode = new ListNode(value);

        if (isEmpty()) {
            last = newNode;
            last.next = newNode;
        } else {
            newNode.next = last.next; 
            last.next = newNode;
            last = newNode;
        }

        length++;
    }

    public ListNode deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty List");
        }

        // First Method
        // if (last == last.next) {
        //     last = null;
        //     length--;
        //     return last;
        // } else {
        //     ListNode deleted = last.next;
        //     last.next = deleted.next;
        //     deleted.next = null;
        //     length--;
        //     return deleted;
        // }

        // Second Method
        ListNode deleted = last.next;
        if (last.next == last) {
            last = null;
        } else {
            last.next = deleted.next;
        }

        deleted.next = null;
        length--;
        return deleted;
    }

    public ListNode deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty List");
        }

        ListNode deleted = last;
        ListNode temp = last;
        if (last == last.next) {
            last = null;
        } else {
            while (temp.next != last) {
                temp = temp.next;
            }
        }

        temp.next = temp.next.next;
        deleted.next = null;
        last = temp;
        length--;
        return deleted;
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.createCircularSinglyLinkedList();
        csll.print();

        csll.addToStart(0);
        csll.print();

        csll.addToEnd(20);
        csll.print();

        System.out.println(csll.deleteFirst().value);
        csll.print();
        
        System.out.println(csll.deleteLast().value);
        csll.print();
    }
}
