// https://leetcode.com/problems/min-stack/

// Solution 1: Auxiliary min stack — O(1) all ops, O(n) space
class MinStack {
    constructor() {
        this.stack = [];
        this.minStack = [];
    }
    push(val) {
        this.stack.push(val);
        const m = this.minStack.length === 0 ? val : Math.min(val, this.minStack[this.minStack.length - 1]);
        this.minStack.push(m);
    }
    pop() { this.stack.pop(); this.minStack.pop(); }
    top() { return this.stack[this.stack.length - 1]; }
    getMin() { return this.minStack[this.minStack.length - 1]; }
}

// Solution 2: Single stack of [val, min] pairs — O(1) all ops, O(n) space
class MinStack2 {
    constructor() { this.stack = []; }
    push(val) {
        const m = this.stack.length === 0 ? val : Math.min(val, this.stack[this.stack.length - 1][1]);
        this.stack.push([val, m]);
    }
    pop() { this.stack.pop(); }
    top() { return this.stack[this.stack.length - 1][0]; }
    getMin() { return this.stack[this.stack.length - 1][1]; }
}
