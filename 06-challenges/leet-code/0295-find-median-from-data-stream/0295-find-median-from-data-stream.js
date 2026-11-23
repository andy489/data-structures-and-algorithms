// https://leetcode.com/problems/find-median-from-data-stream/

// Solution: Two Heaps (Max-heap + Min-heap) — O(log n) add, O(1) findMedian
class MedianFinder {
    constructor() {
        this.lo = new MaxHeap();
        this.hi = new MinHeap();
    }

    addNum(num) {
        this.lo.push(num);
        this.hi.push(this.lo.pop());
        if (this.hi.size() > this.lo.size()) {
            this.lo.push(this.hi.pop());
        }
    }

    findMedian() {
        if (this.lo.size() === this.hi.size()) {
            return (this.lo.peek() + this.hi.peek()) / 2;
        }
        return this.lo.peek();
    }
}

class MinHeap {
    constructor() { this.h = []; }
    size() { return this.h.length; }
    peek() { return this.h[0]; }
    push(v) {
        this.h.push(v);
        this._up(this.h.length - 1);
    }
    pop() {
        const top = this.h[0];
        const last = this.h.pop();
        if (this.h.length) { this.h[0] = last; this._down(0); }
        return top;
    }
    _up(i) {
        while (i > 0) {
            const p = (i - 1) >> 1;
            if (this.h[p] <= this.h[i]) break;
            [this.h[p], this.h[i]] = [this.h[i], this.h[p]]; i = p;
        }
    }
    _down(i) {
        const n = this.h.length;
        while (true) {
            let s = i, l = 2*i+1, r = 2*i+2;
            if (l < n && this.h[l] < this.h[s]) s = l;
            if (r < n && this.h[r] < this.h[s]) s = r;
            if (s === i) break;
            [this.h[s], this.h[i]] = [this.h[i], this.h[s]]; i = s;
        }
    }
}

class MaxHeap extends MinHeap {
    _up(i) {
        while (i > 0) {
            const p = (i - 1) >> 1;
            if (this.h[p] >= this.h[i]) break;
            [this.h[p], this.h[i]] = [this.h[i], this.h[p]]; i = p;
        }
    }
    _down(i) {
        const n = this.h.length;
        while (true) {
            let s = i, l = 2*i+1, r = 2*i+2;
            if (l < n && this.h[l] > this.h[s]) s = l;
            if (r < n && this.h[r] > this.h[s]) s = r;
            if (s === i) break;
            [this.h[s], this.h[i]] = [this.h[i], this.h[s]]; i = s;
        }
    }
}
