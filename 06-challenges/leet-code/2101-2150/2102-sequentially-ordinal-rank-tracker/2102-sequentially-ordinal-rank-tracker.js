// https://leetcode.com/problems/sequentially-ordinal-rank-tracker/

// Solution: Two Heaps — O(log n) per operation
// Invariant: after q calls to get(), `left` holds the top-q best locations
// with the q-th best at left[0] (min-heap by worst-of-best ordering).
// `right` holds the remaining with the best at right[0] (max-heap).
var SORTracker = function() {
    // right: max-heap — best location at [0]
    this.right = new MaxHeap((a, b) => {
        if (a[1] !== b[1]) return a[1] - b[1]; // higher score = better
        return b[0] < a[0] ? 1 : -1;           // lex smaller = better
    });
    // left: min-heap — worst of top-q at [0]
    this.left = new MinHeap((a, b) => {
        if (a[1] !== b[1]) return a[1] - b[1]; // lower score = worse
        return a[0] > b[0] ? -1 : 1;           // lex larger = worse
    });
};

SORTracker.prototype.add = function(name, score) {
    this.right.push([name, score]);
    if (this.left.size() > 0) {
        const lTop = this.left.peek();
        const rTop = this.right.peek();
        const rBetter = rTop[1] > lTop[1] || (rTop[1] === lTop[1] && rTop[0] < lTop[0]);
        if (rBetter) {
            this.left.pop();
            this.right.pop();
            this.left.push(rTop);
            this.right.push(lTop);
        }
    }
};

SORTracker.prototype.get = function() {
    const best = this.right.pop();
    this.left.push(best);
    return this.left.peek()[0];
};

// Simple heap implementations using sorted array for clarity
// (In practice use a proper heap for O(log n))
class MaxHeap {
    constructor(cmp) { this.data = []; this.cmp = cmp; }
    push(val) {
        this.data.push(val);
        this.data.sort((a, b) => -this.cmp(a, b));
    }
    pop() { return this.data.shift(); }
    peek() { return this.data[0]; }
    size() { return this.data.length; }
}

class MinHeap {
    constructor(cmp) { this.data = []; this.cmp = cmp; }
    push(val) {
        this.data.push(val);
        this.data.sort((a, b) => this.cmp(a, b));
    }
    pop() { return this.data.shift(); }
    peek() { return this.data[0]; }
    size() { return this.data.length; }
}
