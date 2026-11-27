// https://leetcode.com/problems/recover-the-original-array/
var recoverArray = function(nums) {
    nums.sort((a, b) => a - b);
    const m = nums.length;
    const n = m >> 1;

    for (let j = 1; j < m; j++) {
        const diff = nums[j] - nums[0];
        if (diff <= 0 || diff % 2 !== 0) continue;
        const twoK = diff;
        const freq = new Map();
        for (const x of nums) freq.set(x, (freq.get(x) || 0) + 1);
        const result = [];
        let valid = true;
        for (const x of nums) {
            if ((freq.get(x) || 0) === 0) continue;
            const higher = x + twoK;
            if ((freq.get(higher) || 0) === 0) { valid = false; break; }
            result.push(x + twoK / 2);
            freq.set(x, freq.get(x) - 1);
            freq.set(higher, freq.get(higher) - 1);
        }
        if (valid) return result;
    }
    return [];
};
