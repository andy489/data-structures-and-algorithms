// https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-ii/

/**
 * @param {number[]} nums
 * @param {number} k
 * @param {number} x
 * @return {number[]}
 */
var findXSum = function (nums, k, x) {
    // JS doesn't have a built-in sorted set; use a simple approach with Map + sorted array rebuilding.
    // For n <= 1e5, an O(n * sqrt(n)) approach works; here we use a balanced approach.
    const n = nums.length;
    const answer = [];
    const freq = new Map();

    // We'll maintain two structures:
    // top: set of (freq, val) for top-x (sorted descending = highest priority)
    // bottom: set of (freq, val) for the rest (sorted ascending)
    // Use TreeSet simulation with sorted array (acceptable for contest).
    // For simplicity, rebuild top-x on each slide using a frequency map — O(k) per step.
    // n * k = 1e5 * 1e5 = 1e10, too slow. Use the two-sorted-sets approach.
    // Implement using two JS Maps with manual sorted-min/max tracking.

    // Simpler: for each window, maintain freq map and recompute x-sum in O(k) only for small k,
    // or use a more sophisticated structure. Here use O(n log n) with sorted array.

    // Practical JS solution: use the sliding window with frequency map and sorted list simulation.
    // Since sortedcontainers isn't available in JS, implement with a sorted list (array) or use a heap.
    // For LeetCode, we can rely on the O(k log k) approach per window is acceptable if n is small.
    // For n=1e5, k=1e5, we need O(n log n).
    // Use two sorted sets implemented as sorted arrays with binary search insertion/deletion.

    class SortedArr {
        constructor(cmp) {
            this.data = [];
            this.cmp = cmp;
        }
        add(item) {
            let lo = 0, hi = this.data.length;
            while (lo < hi) {
                const mid = (lo + hi) >> 1;
                if (this.cmp(this.data[mid], item) < 0) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            this.data.splice(lo, 0, item);
        }
        remove(item) {
            let lo = 0, hi = this.data.length;
            while (lo < hi) {
                const mid = (lo + hi) >> 1;
                const c = this.cmp(this.data[mid], item);
                if (c < 0) {
                    lo = mid + 1;
                } else if (c > 0) {
                    hi = mid;
                } else {
                    this.data.splice(mid, 1);
                    return;
                }
            }
        }
        first() { return this.data[0]; }
        last() { return this.data[this.data.length - 1]; }
        size() { return this.data.length; }
        isEmpty() { return this.data.length === 0; }
    }

    const cmp = (a, b) => a[0] !== b[0] ? a[0] - b[0] : a[1] - b[1];
    const top = new SortedArr(cmp);
    const bottom = new SortedArr(cmp);
    let topSum = 0n;

    function addTop(f, v) {
        top.add([f, v]);
        topSum += BigInt(f) * BigInt(v);
    }
    function removeTop(f, v) {
        top.remove([f, v]);
        topSum -= BigInt(f) * BigInt(v);
    }
    function rebalance() {
        while (top.size() > x) {
            const [f, v] = top.first();
            removeTop(f, v);
            bottom.add([f, v]);
        }
        while (top.size() < x && !bottom.isEmpty()) {
            const [f, v] = bottom.last();
            bottom.remove([f, v]);
            addTop(f, v);
        }
    }

    for (let i = 0; i < n; i++) {
        const v = nums[i];
        const oldF = freq.get(v) || 0;
        const newF = oldF + 1;
        freq.set(v, newF);
        if (oldF > 0) {
            // try to remove from top
            const topIdx = top.data.findIndex(a => a[0] === oldF && a[1] === v);
            if (topIdx !== -1) {
                top.data.splice(topIdx, 1);
                topSum -= BigInt(oldF) * BigInt(v);
            } else {
                bottom.remove([oldF, v]);
            }
        }
        bottom.add([newF, v]);
        rebalance();

        if (i >= k - 1) {
            answer.push(Number(topSum));
            const rem = nums[i - k + 1];
            const remF = freq.get(rem);
            const remIdx = top.data.findIndex(a => a[0] === remF && a[1] === rem);
            if (remIdx !== -1) {
                top.data.splice(remIdx, 1);
                topSum -= BigInt(remF) * BigInt(rem);
            } else {
                bottom.remove([remF, rem]);
            }
            if (remF > 1) {
                bottom.add([remF - 1, rem]);
            }
            freq.set(rem, remF - 1);
            if (freq.get(rem) === 0) {
                freq.delete(rem);
            }
            rebalance();
        }
    }
    return answer;
};
