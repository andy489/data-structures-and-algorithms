// https://leetcode.com/problems/maximum-gap/

// Bucket sort (pigeonhole) — O(n) time, O(n) space
var maximumGap = function(nums) {
    const n = nums.length;
    if (n < 2) return 0;
    let lo = Math.min(...nums), hi = Math.max(...nums);
    if (lo === hi) return 0;
    const w = Math.max(1, Math.ceil((hi - lo) / (n - 1)));
    const buckets = Math.floor((hi - lo) / w) + 1;
    const bMin = new Array(buckets).fill(Infinity);
    const bMax = new Array(buckets).fill(-Infinity);
    for (const x of nums) {
        const i = Math.floor((x - lo) / w);
        bMin[i] = Math.min(bMin[i], x);
        bMax[i] = Math.max(bMax[i], x);
    }
    let gap = 0, prevMax = bMax[0];
    for (let i = 1; i < buckets; i++) {
        if (bMin[i] === Infinity) continue;
        gap = Math.max(gap, bMin[i] - prevMax);
        prevMax = bMax[i];
    }
    return gap;
};
