// https://leetcode.com/problems/bitwise-ors-of-subarrays/

var subarrayBitwiseORs = function(arr) {
    const res = new Set();
    let prev = new Set();
    for (const x of arr) {
        const curr = new Set([x]);
        for (const y of prev) curr.add(x | y);
        for (const v of curr) res.add(v);
        prev = curr;
    }
    return res.size;
};
