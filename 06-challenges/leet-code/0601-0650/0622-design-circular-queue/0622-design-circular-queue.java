// https://leetcode.com/problems/design-circular-queue/

// Solution: Array with Head/Tail Pointers — O(1) operations, O(k) space
class MyCircularQueue {
    private int[] data;
    private int head, tail, size, capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        data = new int[k];
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[(tail - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
