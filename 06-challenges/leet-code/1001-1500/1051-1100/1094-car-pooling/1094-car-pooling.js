// https://leetcode.com/problems/car-pooling/

var carPooling = function(trips, capacity) {
    const diff = new Array(1001).fill(0);
    for (const [n, f, t] of trips) { diff[f] += n; diff[t] -= n; }
    let cur = 0;
    for (const d of diff) {
        cur += d;
        if (cur > capacity) return false;
    }
    return true;
};
