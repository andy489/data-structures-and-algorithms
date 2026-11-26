// https://leetcode.com/problems/all-oone-data-structure/

class AllOne {
    constructor() {
        this.keyToNode = new Map();
        this.head = {count: 0, keys: new Set(), prev: null, next: null};
        this.tail = {count: Infinity, keys: new Set(), prev: null, next: null};
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    _insertAfter(prev, node) {
        node.prev = prev;
        node.next = prev.next;
        prev.next.prev = node;
        prev.next = node;
    }

    _remove(node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    inc(key) {
        if (this.keyToNode.has(key)) {
            const curr = this.keyToNode.get(key);
            let next = curr.next;
            if (next.count !== curr.count + 1) {
                next = {count: curr.count + 1, keys: new Set(), prev: null, next: null};
                this._insertAfter(curr, next);
            }
            next.keys.add(key);
            this.keyToNode.set(key, next);
            curr.keys.delete(key);
            if (curr.keys.size === 0) {
                this._remove(curr);
            }
        } else {
            let first = this.head.next;
            if (first.count !== 1) {
                first = {count: 1, keys: new Set(), prev: null, next: null};
                this._insertAfter(this.head, first);
            }
            first.keys.add(key);
            this.keyToNode.set(key, first);
        }
    }

    dec(key) {
        const curr = this.keyToNode.get(key);
        if (curr.count === 1) {
            this.keyToNode.delete(key);
        } else {
            let prev = curr.prev;
            if (prev.count !== curr.count - 1) {
                prev = {count: curr.count - 1, keys: new Set(), prev: null, next: null};
                this._insertAfter(curr.prev, prev);
            }
            prev.keys.add(key);
            this.keyToNode.set(key, prev);
        }
        curr.keys.delete(key);
        if (curr.keys.size === 0) {
            this._remove(curr);
        }
    }

    getMaxKey() {
        return this.tail.prev === this.head ? "" : this.tail.prev.keys.values().next().value;
    }

    getMinKey() {
        return this.head.next === this.tail ? "" : this.head.next.keys.values().next().value;
    }
}
