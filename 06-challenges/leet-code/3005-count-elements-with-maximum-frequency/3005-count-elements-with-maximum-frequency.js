// https://leetcode.com/problems/count-elements-with-maximum-frequency/

var maxFrequencyElements = function(nums) {
    const freq = new Map();
    for (const x of nums) freq.set(x, (freq.get(x) || 0) + 1);
    const maxFreq = Math.max(...freq.values());
    let total = 0;
    for (const f of freq.values()) if (f === maxFreq) total += f;
    return total;
};
