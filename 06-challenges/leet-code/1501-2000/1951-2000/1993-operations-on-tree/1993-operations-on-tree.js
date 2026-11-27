// https://leetcode.com/problems/operations-on-tree/
/**
 * @param {number[]} parent
 */
var LockingTree = function(parent) {
    this.parent = parent;
    const n = parent.length;
    this.lockedBy = new Int32Array(n);
    this.children = Array.from({length: n}, () => []);
    for (let i = 1; i < n; i++) {
        this.children[parent[i]].push(i);
    }
};

/**
 * @param {number} num
 * @param {number} user
 * @return {boolean}
 */
LockingTree.prototype.lock = function(num, user) {
    if (this.lockedBy[num] !== 0) {
        return false;
    }
    this.lockedBy[num] = user;
    return true;
};

/**
 * @param {number} num
 * @param {number} user
 * @return {boolean}
 */
LockingTree.prototype.unlock = function(num, user) {
    if (this.lockedBy[num] !== user) {
        return false;
    }
    this.lockedBy[num] = 0;
    return true;
};

/**
 * @param {number} num
 * @param {number} user
 * @return {boolean}
 */
LockingTree.prototype.upgrade = function(num, user) {
    if (this.lockedBy[num] !== 0) {
        return false;
    }
    let cur = this.parent[num];
    while (cur !== -1) {
        if (this.lockedBy[cur] !== 0) {
            return false;
        }
        cur = this.parent[cur];
    }
    if (!this._hasLockedDescendant(num)) {
        return false;
    }
    this._unlockDescendants(num);
    this.lockedBy[num] = user;
    return true;
};

LockingTree.prototype._hasLockedDescendant = function(node) {
    for (const child of this.children[node]) {
        if (this.lockedBy[child] !== 0 || this._hasLockedDescendant(child)) {
            return true;
        }
    }
    return false;
};

LockingTree.prototype._unlockDescendants = function(node) {
    for (const child of this.children[node]) {
        this.lockedBy[child] = 0;
        this._unlockDescendants(child);
    }
};
