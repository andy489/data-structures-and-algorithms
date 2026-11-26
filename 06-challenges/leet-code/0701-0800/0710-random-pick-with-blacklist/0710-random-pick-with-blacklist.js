// https://leetcode.com/problems/random-pick-with-blacklist/

class Solution {
    constructor(n, blacklist) {
        this.m = n - blacklist.length;
        const blackSet = new Set(blacklist);
        this.remap = new Map();
        let ptr = this.m;
        for (const b of blacklist) {
            if (b < this.m) {
                while (blackSet.has(ptr)) ptr++;
                this.remap.set(b, ptr++);
            }
        }
    }

    pick() {
        const r = Math.floor(Math.random() * this.m);
        return this.remap.has(r) ? this.remap.get(r) : r;
    }
}
