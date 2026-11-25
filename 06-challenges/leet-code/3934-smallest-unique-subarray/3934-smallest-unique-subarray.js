// https://leetcode.com/problems/smallest-unique-subarray/

var smallestUniqueSubarray = function(nums) {
    const n = nums.length;
    const prev = new Int32Array(n).fill(-1);
    const next = new Int32Array(n).fill(n);
    const last = new Map();
    for (let i = 0; i < n; i++) {
        if (last.has(nums[i])) prev[i] = last.get(nums[i]);
        last.set(nums[i], i);
    }
    last.clear();
    for (let i = n - 1; i >= 0; i--) {
        if (last.has(nums[i])) next[i] = last.get(nums[i]);
        last.set(nums[i], i);
    }

    const check = (k) => {
        const maxDq = [], minDq = [];
        for (let r = 0; r < n; r++) {
            while (maxDq.length && prev[maxDq[maxDq.length - 1]] <= prev[r]) maxDq.pop();
            maxDq.push(r);
            while (minDq.length && next[minDq[minDq.length - 1]] >= next[r]) minDq.pop();
            minDq.push(r);
            if (r >= k - 1) {
                const l = r - k + 1;
                if (maxDq[0] < l) maxDq.shift();
                if (minDq[0] < l) minDq.shift();
                if (prev[maxDq[0]] < l && next[minDq[0]] > r) return true;
            }
        }
        return false;
    };

    let lo = 1, hi = n;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (check(mid)) hi = mid;
        else lo = mid + 1;
    }
    return lo;
};
