// https://leetcode.com/problems/design-hashmap/

const BUCKETS = 769;

class MyHashMap {
    constructor() {
        this.data = Array.from({ length: BUCKETS }, () => []);
    }

    _hash(key) {
        return key % BUCKETS;
    }

    put(key, value) {
        const h = this._hash(key);
        const pair = this.data[h].find(p => p[0] === key);
        if (pair) {
            pair[1] = value;
        } else {
            this.data[h].push([key, value]);
        }
    }

    get(key) {
        const pair = this.data[this._hash(key)].find(p => p[0] === key);
        return pair ? pair[1] : -1;
    }

    remove(key) {
        const h = this._hash(key);
        this.data[h] = this.data[h].filter(p => p[0] !== key);
    }
}
