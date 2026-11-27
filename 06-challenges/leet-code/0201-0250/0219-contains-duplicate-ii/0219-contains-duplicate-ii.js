// https://leetcode.com/problems/contains-duplicate-ii/

// Solution: Sliding Window HashSet — O(n) time, O(k) space
var containsNearbyDuplicate = function(nums, k) {
    const window = new Set();
    for (let i = 0; i < nums.length; i++) {
        if (window.has(nums[i])) return true;
        window.add(nums[i]);
        if (window.size > k) window.delete(nums[i - k]);
    }
    return false;
};
