// https://leetcode.com/problems/design-an-ordered-stream/

var OrderedStream = function(n) {
    this.data = new Array(n + 1).fill(null);
    this.ptr = 1;
};

OrderedStream.prototype.insert = function(idKey, value) {
    this.data[idKey] = value;
    const result = [];
    while (this.ptr < this.data.length && this.data[this.ptr] !== null) {
        result.push(this.data[this.ptr++]);
    }
    return result;
};
