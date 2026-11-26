// https://leetcode.com/problems/h-index/

// Solution: Counting Sort / Bucket — O(n) time, O(n) space
var hIndex = function(citations) {
    const n = citations.length;
    const bucket = new Array(n + 1).fill(0);
    for (const c of citations) bucket[Math.min(c, n)]++;
    let count = 0;
    for (let i = n; i >= 0; i--) {
        count += bucket[i];
        if (count >= i) return i;
    }
    return 0;
};
