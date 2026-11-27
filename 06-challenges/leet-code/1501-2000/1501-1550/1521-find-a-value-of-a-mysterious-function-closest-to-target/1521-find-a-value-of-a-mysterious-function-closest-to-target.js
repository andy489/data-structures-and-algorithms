// https://leetcode.com/problems/find-a-value-of-a-mysterious-function-closest-to-target/

var closestToTarget = function(arr, target) {
    let ans = Infinity;
    let cur = new Set();
    for (const x of arr) {
        const next = new Set([x]);
        for (const v of cur) next.add(v & x);
        cur = next;
        for (const v of cur) ans = Math.min(ans, Math.abs(v - target));
    }
    return ans;
};
