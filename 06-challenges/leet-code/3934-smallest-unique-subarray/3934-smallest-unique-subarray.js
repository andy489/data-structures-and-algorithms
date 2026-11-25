// https://leetcode.com/problems/smallest-unique-subarray/

var minUniqueSubarrayLength = function(nums) {
    const n = nums.length;

    const hasUnique = (k) => {
        const freq = new Map();
        let win = nums.slice(0, k);
        let key = win.join(',');
        freq.set(key, (freq.get(key) || 0) + 1);
        for (let i = k; i < n; i++) {
            win.shift();
            win.push(nums[i]);
            key = win.join(',');
            freq.set(key, (freq.get(key) || 0) + 1);
        }
        for (const cnt of freq.values()) if (cnt === 1) return true;
        return false;
    };

    let lo = 1, hi = n;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (hasUnique(mid)) hi = mid;
        else lo = mid + 1;
    }
    return lo;
};
