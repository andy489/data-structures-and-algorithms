// https://leetcode.com/problems/map-sum-pairs/

var MapSum = function() {
    this.store = new Map();
};

MapSum.prototype.insert = function(key, val) {
    this.store.set(key, val);
};

MapSum.prototype.sum = function(prefix) {
    let total = 0;
    for (const [key, val] of this.store) {
        if (key.startsWith(prefix)) total += val;
    }
    return total;
};
