// https://leetcode.com/problems/flatten-nested-list-iterator/

// Solution: Eager Flattening — O(n) build, O(1) next/hasNext
class NestedIterator {
    constructor(nestedList) {
        this.flat = [];
        this.idx = 0;
        this._flatten(nestedList);
    }

    _flatten(list) {
        for (const ni of list) {
            if (ni.isInteger()) {
                this.flat.push(ni.getInteger());
            } else {
                this._flatten(ni.getList());
            }
        }
    }

    hasNext() {
        return this.idx < this.flat.length;
    }

    next() {
        return this.flat[this.idx++];
    }
}
