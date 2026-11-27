// https://leetcode.com/problems/dinner-plate-stacks/

class DinnerPlates {
    constructor(capacity) {
        this.cap = capacity;
        this.stacks = [];
        this.available = new MinHeap(); // indices with space
    }

    push(val) {
        // Clean stale entries
        while (this.available.size() > 0 && this.available.peek() < this.stacks.length
               && this.stacks[this.available.peek()].length >= this.cap) {
            this.available.pop();
        }
        let idx;
        if (this.available.size() === 0) {
            idx = this.stacks.length;
            this.stacks.push([]);
            this.available.push(idx);
        } else {
            idx = this.available.peek();
        }
        this.stacks[idx].push(val);
        if (this.stacks[idx].length >= this.cap) {
            this.available.pop();
        }
    }

    pop() {
        while (this.stacks.length > 0 && this.stacks[this.stacks.length - 1].length === 0) {
            this.stacks.pop();
        }
        if (this.stacks.length === 0) {
            return -1;
        }
        const idx = this.stacks.length - 1;
        const val = this.stacks[idx].pop();
        this.available.push(idx);
        while (this.stacks.length > 0 && this.stacks[this.stacks.length - 1].length === 0) {
            this.stacks.pop();
        }
        return val;
    }

    popAtStack(index) {
        if (index >= this.stacks.length || this.stacks[index].length === 0) {
            return -1;
        }
        const val = this.stacks[index].pop();
        this.available.push(index);
        while (this.stacks.length > 0 && this.stacks[this.stacks.length - 1].length === 0) {
            this.stacks.pop();
        }
        return val;
    }
}

class MinHeap {
    constructor() { this.h = []; }
    size() { return this.h.length; }
    peek() { return this.h[0]; }
    push(val) {
        this.h.push(val);
        this._up(this.h.length - 1);
    }
    pop() {
        const top = this.h[0];
        const last = this.h.pop();
        if (this.h.length > 0) { this.h[0] = last; this._down(0); }
        return top;
    }
    _up(i) {
        while (i > 0) {
            const p = (i - 1) >> 1;
            if (this.h[p] <= this.h[i]) { break; }
            [this.h[p], this.h[i]] = [this.h[i], this.h[p]];
            i = p;
        }
    }
    _down(i) {
        const n = this.h.length;
        while (true) {
            let m = i, l = 2 * i + 1, r = l + 1;
            if (l < n && this.h[l] < this.h[m]) { m = l; }
            if (r < n && this.h[r] < this.h[m]) { m = r; }
            if (m === i) { break; }
            [this.h[m], this.h[i]] = [this.h[i], this.h[m]];
            i = m;
        }
    }
}
