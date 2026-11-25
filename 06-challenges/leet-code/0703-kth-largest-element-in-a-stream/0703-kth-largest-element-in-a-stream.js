// https://leetcode.com/problems/kth-largest-element-in-a-stream/

class KthLargest {
    constructor(k, nums) {
        this.k = k;
        this.heap = new MinPriorityQueue();
        for (const num of nums) {
            this.heap.enqueue(num);
            if (this.heap.size() > k) {
                this.heap.dequeue();
            }
        }
    }

    add(val) {
        this.heap.enqueue(val);
        if (this.heap.size() > this.k) {
            this.heap.dequeue();
        }
        return this.heap.front().element;
    }
}
