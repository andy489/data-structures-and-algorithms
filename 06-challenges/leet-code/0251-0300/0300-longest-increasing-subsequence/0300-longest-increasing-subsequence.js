// https://leetcode.com/problems/longest-increasing-subsequence/

// Solution: Binary Search (Patience Sorting) — O(n log n) time, O(n) space
var lengthOfLIS = function(nums) {
    const tails = [];
    for (const num of nums) {
        let lo = 0, hi = tails.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (tails[mid] < num) lo = mid + 1;
            else hi = mid;
        }
        tails[lo] = num;
    }
    return tails.length;
};
