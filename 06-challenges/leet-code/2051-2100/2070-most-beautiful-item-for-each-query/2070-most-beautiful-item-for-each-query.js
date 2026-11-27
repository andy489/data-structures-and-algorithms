// https://leetcode.com/problems/most-beautiful-item-for-each-query/

// Solution: Sort + Offline — O((n+q) log n) time, O(n+q) space
var maximumBeauty = function(items, queries) {
    items.sort((a, b) => a[0] - b[0]);
    const q = queries.length;
    const qi = queries.map((v, i) => [v, i]).sort((a, b) => a[0] - b[0]);
    const res = new Array(q).fill(0);
    let j = 0, maxB = 0;
    for (const [val, idx] of qi) {
        while (j < items.length && items[j][0] <= val) { maxB = Math.max(maxB, items[j][1]); j++; }
        res[idx] = maxB;
    }
    return res;
};
