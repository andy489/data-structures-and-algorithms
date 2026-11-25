// https://leetcode.com/problems/time-based-key-value-store/

var TimeMap = function() {
    this.map = new Map();
};

TimeMap.prototype.set = function(key, value, timestamp) {
    if (!this.map.has(key)) this.map.set(key, []);
    this.map.get(key).push([timestamp, value]);
};

TimeMap.prototype.get = function(key, timestamp) {
    if (!this.map.has(key)) return '';
    const arr = this.map.get(key);
    let lo = 0, hi = arr.length - 1, idx = -1;
    while (lo <= hi) {
        const mid = (lo + hi) >> 1;
        if (arr[mid][0] <= timestamp) { idx = mid; lo = mid + 1; }
        else hi = mid - 1;
    }
    return idx === -1 ? '' : arr[idx][1];
};
