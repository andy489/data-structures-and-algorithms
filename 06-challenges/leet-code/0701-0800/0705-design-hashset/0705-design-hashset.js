// https://leetcode.com/problems/design-hashset/

const BUCKETS = 769;

class MyHashSet {
    constructor() {
        this.data = Array.from({ length: BUCKETS }, () => []);
    }

    _hash(key) {
        return key % BUCKETS;
    }

    add(key) {
        const h = this._hash(key);
        if (!this.data[h].includes(key)) {
            this.data[h].push(key);
        }
    }

    remove(key) {
        const h = this._hash(key);
        const idx = this.data[h].indexOf(key);
        if (idx !== -1) {
            this.data[h].splice(idx, 1);
        }
    }

    contains(key) {
        return this.data[this._hash(key)].includes(key);
    }
}
