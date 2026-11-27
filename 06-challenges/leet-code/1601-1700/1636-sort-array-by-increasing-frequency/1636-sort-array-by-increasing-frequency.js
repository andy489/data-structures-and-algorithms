// https://leetcode.com/problems/sort-array-by-increasing-frequency/

var frequencySort = function(nums) {
    const freq = new Map();
    for (const x of nums) {
        freq.set(x, (freq.get(x) || 0) + 1);
    }
    return nums.sort((a, b) => {
        const fa = freq.get(a), fb = freq.get(b);
        return fa !== fb ? fa - fb : b - a;
    });
};
