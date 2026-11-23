// https://leetcode.com/problems/random-flip-matrix/

class Solution {
    constructor(m, n) {
        this.m = m;
        this.n = n;
        this.remaining = m * n;
        this.remapped = new Map();
    }

    flip() {
        const r = Math.floor(Math.random() * this.remaining--);
        const actual = this.remapped.has(r) ? this.remapped.get(r) : r;
        this.remapped.set(r, this.remapped.has(this.remaining) ? this.remapped.get(this.remaining) : this.remaining);
        return [Math.floor(actual / this.n), actual % this.n];
    }

    reset() {
        this.remaining = this.m * this.n;
        this.remapped.clear();
    }
}
