// https://leetcode.com/problems/find-array-given-subset-sums/

// Solution: Recursive Divide and Conquer — O(n^2 * log n) time, O(n) space
var recoverArray = function(n, sums) {
    sums.sort((a, b) => a - b);
    const result = [];

    while (sums.length > 1) {
        const d = sums[sums.length - 1] - sums[sums.length - 2];
        const cnt = new Map();
        for (const s of sums) {
            cnt.set(s, (cnt.get(s) || 0) + 1);
        }
        const withD = [];
        const withoutD = [];
        const sortedKeys = [...cnt.keys()].sort((a, b) => b - a);
        for (const key of sortedKeys) {
            while ((cnt.get(key) || 0) > 0) {
                withD.push(key);
                cnt.set(key, cnt.get(key) - 1);
                const prev = key - d;
                cnt.set(prev, (cnt.get(prev) || 0) - 1);
                withoutD.push(prev);
            }
        }
        withoutD.sort((a, b) => a - b);
        if (withoutD.includes(0)) {
            sums = withoutD;
            result.push(d);
        } else {
            withD.sort((a, b) => a - b);
            sums = withD;
            result.push(-d);
        }
    }
    return result;
};
