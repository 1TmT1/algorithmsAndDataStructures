package data_structures;

public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void printSinglyLinkedList() {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public int findLength() {
        if (head == null) {
            return 0;
        }

        int counter = 0;
        ListNode current = head;
        while (current != null) {
            counter++;
            current = current.next;
        }

        return counter;
    }

    public void addToBeginning(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void addToEnd(int value) {
        ListNode newNode = new ListNode(value);
        
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void addToIndex(int value, int position) {
        ListNode newNode = new ListNode(value);
        
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else if (position < 1) {
            System.out.println("Position is out of bounds (smaller than 1)");
        } else if (position > this.findLength()) {
            System.out.println("Position is out of bounds (larger than the linked list)");
        } else {
            ListNode prev =  head;
            int counter = 1;

            while (counter < position - 1) {
                prev = prev.next;
                counter++;
            }

            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    public ListNode deleteFirstNode() {
        if (head == null) {
            return null;
        }
        
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public ListNode deleteLastNode() {
        if (head == null) {
            return new ListNode(0);
        } else if (head.next == null) {
            head.data = 0;
            return head;
        } else {
            ListNode current = head;

            while (current.next.next != null) {
                current = current.next;
            }

            ListNode prev = current;
            ListNode end = current.next;
            
            prev.next = null;
            
            return end;
        }
    }

    public ListNode deleteNodeInIndex(int position) {
        if (position < 1) {
            System.out.println("Position is too low (lower than 1)");
            return null;
        } else if (position > this.findLength()) {
            System.out.println("Position is too high (higher than the length of the linked list)");
            return null;
        } else if (position == 1) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return temp;
        } else {
            ListNode prev = head;
            int counter = 1;
            
            while (counter < position - 1) {
                prev = prev.next;
                counter++;
            }

            ListNode current = prev.next;
            prev.next = current.next;
            return current;
        }
    }

    public boolean search(int value) {
        if (head == null) {
            return false;
        }

        ListNode current = head;

        while (current != null) {
            if (current.data == value) {
                return true;
            }
            
            current = current.next;
        }

        return false;
    }

    public ListNode reverse() {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public ListNode findIndexFromEnd(int position) {
        if (position < 1) {
            System.out.println("Position is too low (lower than 1)");
            return null;
        } else if (position > this.findLength()) {
            System.out.println("Position is too high (higher than the linked list length)");
            return null;
        } else {
            ListNode mainPointer = head;
            ListNode referencePointer = head;
            int counter = 0;

            while (counter < position) {
                referencePointer = referencePointer.next;
                counter++;
            }

            while (referencePointer != null) {
                mainPointer = mainPointer.next;
                referencePointer = referencePointer.next;
            }

            return mainPointer;
        }
    }

    public void deleteDuplicatesFromSortedList() {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void insertInSortedList(int value) {
        ListNode newNode = new ListNode(value);
        ListNode current = head;
        ListNode temp = null;

        while (current != null && current.data < value) {
            temp = current;
            current = current.next;
        }

        if (temp == null) {
            System.out.println("Linked list is not properly sorted");
        } else {
            newNode.next = current;
            temp.next = newNode;    
        }
    }

    public void deleteValueFromLinkedList(int value) {
        ListNode current = head;
        ListNode prev = null; 
        // 5 -> 6 -> 10 -> null
        while (current != null && current.data != value) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
            current.next = null;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(7);
        ListNode third = new ListNode(4);
        ListNode fourth = new ListNode(1);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        sll.printSinglyLinkedList();
        System.out.println(sll.findLength());

        sll.addToBeginning(100);
        sll.printSinglyLinkedList();

        sll.addToEnd(-5);
        sll.printSinglyLinkedList();

        sll.addToIndex(6, 3);
        sll.printSinglyLinkedList();
        sll.addToIndex(6, 3);
        sll.printSinglyLinkedList();

        ListNode deleted = sll.deleteFirstNode();
        System.out.println("Deleted node value: " + deleted.data);
        sll.printSinglyLinkedList();

        deleted = sll.deleteLastNode();
        System.out.println("Deleted node value: " + deleted.data);
        sll.printSinglyLinkedList();

        deleted = sll.deleteNodeInIndex(4);
        System.out.println("Deleted node value: " + deleted.data);
        sll.printSinglyLinkedList();

        System.out.println(sll.search(4));

        sll.head = sll.reverse();
        sll.printSinglyLinkedList();

        System.out.println("Value of node: " + sll.findIndexFromEnd(2).data);
        
        sll.deleteDuplicatesFromSortedList();
        sll.printSinglyLinkedList();

        sll.insertInSortedList(2);
        sll.printSinglyLinkedList();
        
        sll.deleteValueFromLinkedList(4);
        sll.printSinglyLinkedList();
    }
}
