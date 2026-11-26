// https://leetcode.com/problems/lru-cache/

// Solution 1: HashMap + doubly-linked list — O(1) time, O(n) space
class LRUCache {
    constructor(capacity) {
        this.capacity = capacity;
        this.map = new Map();
        this.head = { key: 0, val: 0, prev: null, next: null };
        this.tail = { key: 0, val: 0, prev: null, next: null };
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    get(key) {
        const node = this.map.get(key);
        if (!node) return -1;
        this._moveToFront(node);
        return node.val;
    }

    put(key, value) {
        let node = this.map.get(key);
        if (node) {
            node.val = value;
            this._moveToFront(node);
        } else {
            node = { key, val: value, prev: null, next: null };
            this.map.set(key, node);
            this._addAfterHead(node);
            if (this.map.size > this.capacity) {
                const lru = this.tail.prev;
                this._remove(lru);
                this.map.delete(lru.key);
            }
        }
    }

    _addAfterHead(node) {
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }

    _remove(node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    _moveToFront(node) {
        this._remove(node);
        this._addAfterHead(node);
    }
}

// Solution 2: Map (insertion/access order) — O(1) amortised, O(n) space
class LRUCache2 {
    constructor(capacity) {
        this.capacity = capacity;
        this.cache = new Map();
    }

    get(key) {
        if (!this.cache.has(key)) return -1;
        const val = this.cache.get(key);
        this.cache.delete(key);
        this.cache.set(key, val);
        return val;
    }

    put(key, value) {
        if (this.cache.has(key)) this.cache.delete(key);
        this.cache.set(key, value);
        if (this.cache.size > this.capacity) {
            this.cache.delete(this.cache.keys().next().value);
        }
    }
}
