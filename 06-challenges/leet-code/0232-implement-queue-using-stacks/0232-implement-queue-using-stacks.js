// https://leetcode.com/problems/implement-queue-using-stacks/

// Solution: Two Stacks, Lazy Transfer — Amortized O(1) per operation
class MyQueue {
    constructor() {
        this.inbox = [];
        this.outbox = [];
    }
    push(x) { this.inbox.push(x); }
    pop() { this._transfer(); return this.outbox.pop(); }
    peek() { this._transfer(); return this.outbox[this.outbox.length - 1]; }
    empty() { return !this.inbox.length && !this.outbox.length; }
    _transfer() {
        if (!this.outbox.length) {
            while (this.inbox.length) this.outbox.push(this.inbox.pop());
        }
    }
}
