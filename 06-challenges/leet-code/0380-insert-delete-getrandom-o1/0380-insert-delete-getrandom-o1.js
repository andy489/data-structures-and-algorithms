// https://leetcode.com/problems/insert-delete-getrandom-o1/

// Solution: HashMap + Array — O(1) average time, O(n) space
class RandomizedSet {
    constructor() {
        this.map = new Map();
        this.vals = [];
    }

    insert(val) {
        if (this.map.has(val)) return false;
        this.map.set(val, this.vals.length);
        this.vals.push(val);
        return true;
    }

    remove(val) {
        if (!this.map.has(val)) return false;
        const idx = this.map.get(val);
        const last = this.vals[this.vals.length - 1];
        this.vals[idx] = last;
        this.map.set(last, idx);
        this.vals.pop();
        this.map.delete(val);
        return true;
    }

    getRandom() {
        return this.vals[Math.floor(Math.random() * this.vals.length)];
    }
}
