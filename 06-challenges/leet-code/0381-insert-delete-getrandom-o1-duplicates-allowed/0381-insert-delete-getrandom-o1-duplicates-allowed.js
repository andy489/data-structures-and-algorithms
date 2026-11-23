// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

// Solution: Map<val, Set<idx>> + Array — O(1) average time, O(n) space
class RandomizedCollection {
    constructor() {
        this.indices = new Map();
        this.vals = [];
    }

    insert(val) {
        if (!this.indices.has(val)) this.indices.set(val, new Set());
        const absent = this.indices.get(val).size === 0;
        this.indices.get(val).add(this.vals.length);
        this.vals.push(val);
        return absent;
    }

    remove(val) {
        if (!this.indices.has(val) || this.indices.get(val).size === 0) return false;
        const idx = this.indices.get(val).values().next().value;
        this.indices.get(val).delete(idx);
        const last = this.vals[this.vals.length - 1];
        if (idx < this.vals.length - 1) {
            this.vals[idx] = last;
            this.indices.get(last).delete(this.vals.length - 1);
            this.indices.get(last).add(idx);
        }
        this.vals.pop();
        return true;
    }

    getRandom() {
        return this.vals[Math.floor(Math.random() * this.vals.length)];
    }
}
