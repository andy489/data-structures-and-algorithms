// https://leetcode.com/problems/house-robber-iv/

// Solution: Binary Search on Answer — O(n log(max)) time, O(1) space
var minCapability = function(nums, k) {
    function canRob(cap) {
        let count = 0;
        for (let i = 0; i < nums.length; i++) {
            if (nums[i] <= cap) {
                count++;
                i++; // skip adjacent
            }
        }
        return count >= k;
    }

    let lo = Math.min(...nums), hi = Math.max(...nums);
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (canRob(mid)) {
            hi = mid;
        } else {
            lo = mid + 1;
        }
    }
    return lo;
};
