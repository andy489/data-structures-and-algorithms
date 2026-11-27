// https://leetcode.com/problems/longest-harmonious-subsequence/
var findLHS = function(nums) {
    const frequency = new Map();
    for (const num of nums) {
        frequency.set(num, (frequency.get(num) || 0) + 1);
    }
    let longest = 0;
    for (const [key, cnt] of frequency) {
        if (frequency.has(key + 1)) {
            longest = Math.max(longest, cnt + frequency.get(key + 1));
        }
    }
    return longest;
};
