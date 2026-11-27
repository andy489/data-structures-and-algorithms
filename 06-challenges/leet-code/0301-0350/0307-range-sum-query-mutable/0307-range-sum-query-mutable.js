// https://leetcode.com/problems/range-sum-query-mutable/

var NumArray = function(nums) {
    this.n = nums.length;
    this.nums = [...nums];
    this.bit = new Array(this.n + 1).fill(0);
    for (let i = 0; i < this.n; i++) this._add(i + 1, nums[i]);
};
NumArray.prototype._add = function(i, delta) {
    for (; i <= this.n; i += i & -i) this.bit[i] += delta;
};
NumArray.prototype._query = function(i) {
    let s = 0;
    for (; i > 0; i -= i & -i) s += this.bit[i];
    return s;
};
NumArray.prototype.update = function(index, val) {
    this._add(index + 1, val - this.nums[index]);
    this.nums[index] = val;
};
NumArray.prototype.sumRange = function(left, right) {
    return this._query(right + 1) - this._query(left);
};
