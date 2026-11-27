// https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/
var findLonely = function(nums) {
    const freq = new Map();
    for (const x of nums) {
        freq.set(x, (freq.get(x) || 0) + 1);
    }
    const result = [];
    for (const [x, cnt] of freq) {
        if (cnt === 1 && !freq.has(x - 1) && !freq.has(x + 1)) {
            result.push(x);
        }
    }
    return result;
};
