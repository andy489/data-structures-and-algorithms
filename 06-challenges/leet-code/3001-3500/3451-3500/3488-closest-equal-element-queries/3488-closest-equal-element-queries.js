// https://leetcode.com/problems/closest-equal-element-queries/

var solveQueries = function(nums, queries) {
    const n = nums.length;
    const positions = new Map();
    for (let i = 0; i < n; i++) {
        if (!positions.has(nums[i])) positions.set(nums[i], []);
        positions.get(nums[i]).push(i);
    }
    const bisect = (arr, val) => {
        let lo = 0, hi = arr.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (arr[mid] < val) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    };
    return queries.map(idx => {
        const v = nums[idx];
        const pos = positions.get(v);
        if (pos.length === 1) return -1;
        const p = bisect(pos, idx);
        let best = Infinity;
        for (const nb of [(p - 1 + pos.length) % pos.length, (p + 1) % pos.length]) {
            const d = Math.abs(pos[nb] - idx);
            best = Math.min(best, d, n - d);
        }
        return best;
    });
};
