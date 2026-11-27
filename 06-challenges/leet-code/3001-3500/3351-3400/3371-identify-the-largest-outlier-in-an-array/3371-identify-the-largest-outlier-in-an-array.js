// https://leetcode.com/problems/identify-the-largest-outlier-in-an-array/

var getLargestOutlier = function(nums) {
    let total = 0;
    const freq = new Map();
    for (const x of nums) {
        total += x;
        freq.set(x, (freq.get(x) || 0) + 1);
    }
    let ans = -Infinity;
    for (const x of nums) {
        const remainder = total - x;
        if (remainder % 2 !== 0) {
            continue;
        }
        const need = remainder / 2;
        freq.set(x, freq.get(x) - 1);
        if ((freq.get(need) || 0) > 0) {
            ans = Math.max(ans, x);
        }
        freq.set(x, freq.get(x) + 1);
    }
    return ans;
};
