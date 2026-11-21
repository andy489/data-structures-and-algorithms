// https://leetcode.com/problems/longest-consecutive-sequence/

// Solution: Hash Set — O(n) time, O(n) space
var longestConsecutive = function(nums) {
    const set = new Set(nums);
    let ans = 0;
    for (const n of set) {
        if (!set.has(n - 1)) {
            let len = 1;
            while (set.has(n + len)) len++;
            ans = Math.max(ans, len);
        }
    }
    return ans;
};
