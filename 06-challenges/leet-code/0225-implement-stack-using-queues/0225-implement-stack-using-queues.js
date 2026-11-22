// https://leetcode.com/problems/implement-stack-using-queues/

// Solution: Single Queue, rotate on push — O(n) push, O(1) others
class MyStack {
    constructor() {
        this.queue = [];
    }
    push(x) {
        this.queue.push(x);
        for (let i = 0; i < this.queue.length - 1; i++) {
            this.queue.push(this.queue.shift());
        }
    }
    pop() { return this.queue.shift(); }
    top() { return this.queue[0]; }
    empty() { return this.queue.length === 0; }
}
