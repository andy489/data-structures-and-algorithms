// https://leetcode.com/problems/binary-search-tree-iterator/

// Solution 1: Controlled stack — O(1) avg time, O(h) space
class BSTIterator {
    constructor(root) {
        this.stack = [];
        this._pushLeft(root);
    }

    next() {
        const node = this.stack.pop();
        this._pushLeft(node.right);
        return node.val;
    }

    hasNext() {
        return this.stack.length > 0;
    }

    _pushLeft(node) {
        while (node) {
            this.stack.push(node);
            node = node.left;
        }
    }
}

// Solution 2: Flattened list — O(n) init, O(1) per call, O(n) space
class BSTIterator2 {
    constructor(root) {
        this.vals = [];
        this.idx = 0;
        this._inorder(root);
    }

    next() {
        return this.vals[this.idx++];
    }

    hasNext() {
        return this.idx < this.vals.length;
    }

    _inorder(node) {
        if (!node) return;
        this._inorder(node.left);
        this.vals.push(node.val);
        this._inorder(node.right);
    }
}
