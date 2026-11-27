// https://leetcode.com/problems/rle-iterator/

var RLEIterator = function(encoding) {
    this.enc = encoding;
    this.idx = 0;
};

RLEIterator.prototype.next = function(n) {
    while (this.idx < this.enc.length && n > this.enc[this.idx]) {
        n -= this.enc[this.idx];
        this.idx += 2;
    }
    if (this.idx >= this.enc.length) return -1;
    this.enc[this.idx] -= n;
    return this.enc[this.idx + 1];
};
