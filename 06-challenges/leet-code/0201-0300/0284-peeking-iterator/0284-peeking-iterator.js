// https://leetcode.com/problems/peeking-iterator/

// Solution: Cache Next Element — O(1) per operation, O(1) space
class PeekingIterator {
    constructor(iterator) {
        this._iter = iterator;
        this._peeked = this._iter.hasNext() ? this._iter.next() : null;
    }

    peek() {
        return this._peeked;
    }

    next() {
        const val = this._peeked;
        this._peeked = this._iter.hasNext() ? this._iter.next() : null;
        return val;
    }

    hasNext() {
        return this._peeked !== null;
    }
}
