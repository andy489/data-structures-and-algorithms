// https://leetcode.com/problems/maximum-total-beauty-of-the-gardens/

/**
 * @param {number[]} flowers
 * @param {number} newFlowers
 * @param {number} target
 * @param {number} full
 * @param {number} partial
 * @return {number}
 */
var maximumBeauty = function(flowers, newFlowers, target, full, partial) {
    const n = flowers.length;
    flowers = flowers.map(f => Math.min(f, target)).sort((a, b) => a - b);

    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + flowers[i];
    }

    let ans = 0n;
    let remaining = BigInt(newFlowers);

    for (let c = 0; c <= n; c++) {
        if (c > 0) {
            const cost = BigInt(Math.max(0, target - flowers[n - c]));
            remaining -= cost;
        }
        if (remaining < 0n) {
            break;
        }

        const incomplete = n - c;
        let minVal = 0;
        if (incomplete > 0) {
            let lo = 0, hi = target - 1;
            while (lo < hi) {
                const mid = (lo + hi + 1) >> 1;
                // Find leftmost idx in [0, incomplete) where flowers[idx] >= mid
                let left = 0, right = incomplete;
                while (left < right) {
                    const m = (left + right) >> 1;
                    if (flowers[m] < mid) { left = m + 1; } else { right = m; }
                }
                const idx = left;
                const needed = BigInt(mid) * BigInt(idx) - BigInt(prefix[idx]);
                if (needed <= remaining) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            minVal = lo;
        }

        const beauty = BigInt(c) * BigInt(full) + BigInt(minVal) * BigInt(partial);
        if (beauty > ans) {
            ans = beauty;
        }
    }

    return Number(ans);
};
