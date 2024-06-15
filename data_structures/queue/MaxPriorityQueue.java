package data_structures.queue;

public class MaxPriorityQueue {
    private Integer[] heap;
    private int n;

    public MaxPriorityQueue(int capacity) {
        this.heap = new Integer[capacity + 1];
        this.n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void print() {
        for (int i = 1; i < n; i++) {
            System.out.print(heap[i] + ", ");
        }

        System.out.println(heap[n]);
    }

    private void resize(int cap) {
        Integer[] temp = new Integer[cap];

        for (int i = 1; i < heap.length; i++) {
            temp[i] = heap[i];
        }

        heap = temp;
    }

    public void insert(int x) {
        if (n == heap.length - 1) {
            resize(heap.length * 2);
        }

        n++;
        heap[n] = x;
        swim(n);
    }

    private void swim(int x) {
        while (x > 1 && heap[x/2] < heap[x]) {
            swap(x, x / 2);
            x = x / 2;
        }
    }

    private void sink(int x) {
        while (x * 2 <= n) {
            int y = x * 2;

            if (y < n && heap[y] < heap[y + 1]) {
                y++;
            }

            if (heap[x] >= heap[y]) {
                break;
            }

            swap(x, y);
            x = y;
        }
    }

    public int deleteMax() {
        int max = heap[1];
        swap(1, n);
        n--;
        sink(1);
        heap[n + 1] = null;
        
        if (n > 0 && (n == (heap.length - 1) / 4)) {
            resize(heap.length / 2);
        }

        return max;
    }

    public void swap(int x, int y) {
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }

    public static void main(String[] main) {
        MaxPriorityQueue maxPQ = new MaxPriorityQueue(5);
        
        System.out.println(maxPQ.size());
        System.out.println(maxPQ.isEmpty());

        maxPQ.insert(5);
        maxPQ.insert(10);
        maxPQ.insert(1);
        maxPQ.insert(7);

        System.out.println(maxPQ.size());
        
        maxPQ.print();

        System.out.println(maxPQ.deleteMax());
        maxPQ.print();
    }
}
