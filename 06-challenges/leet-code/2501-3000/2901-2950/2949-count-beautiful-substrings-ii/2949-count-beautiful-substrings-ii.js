// https://leetcode.com/problems/count-beautiful-substrings-ii/

var beautifulSubstrings = function(s, k) {
    let p = 1;
    while ((p * p) % k !== 0) p++;
    const period = 2 * p;

    const vowelSet = new Set(['a','e','i','o','u']);
    const n = s.length;
    let count = 0;
    let pre = 0;
    const freq = new Map();
    const key0 = `0,0`;
    freq.set(key0, 1);

    for (let j = 0; j < n; j++) {
        pre += vowelSet.has(s[j]) ? 1 : -1;
        const key = `${pre},${(j + 1) % period}`;
        count += (freq.get(key) || 0);
        freq.set(key, (freq.get(key) || 0) + 1);
    }

    return count;
};
