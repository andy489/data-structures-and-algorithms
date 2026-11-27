// https://leetcode.com/problems/sorted-gcd-pair-queries/

/**
 * @param {number[]} nums
 * @param {number[]} queries
 * @return {number[]}
 */
var gcdValues = function (nums, queries) {
    const maxVal = Math.max(...nums);
    const cnt = new Array(maxVal + 1).fill(0);
    for (const x of nums) {
        cnt[x]++;
    }
    for (let g = 1; g <= maxVal; g++) {
        for (let mult = 2 * g; mult <= maxVal; mult += g) {
            cnt[g] += cnt[mult];
        }
    }
    const pairs = new Array(maxVal + 1).fill(0);
    for (let g = maxVal; g >= 1; g--) {
        pairs[g] = BigInt(cnt[g]) * BigInt(cnt[g] - 1) / 2n;
        for (let mult = 2 * g; mult <= maxVal; mult += g) {
            pairs[g] -= pairs[mult];
        }
    }
    const prefix = new Array(maxVal + 1).fill(0n);
    for (let g = 1; g <= maxVal; g++) {
        prefix[g] = prefix[g - 1] + pairs[g];
    }
    const ans = [];
    for (const q of queries) {
        const qb = BigInt(q);
        let lo = 1, hi = maxVal;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (prefix[mid] > qb) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        ans.push(lo);
    }
    return ans;
};
