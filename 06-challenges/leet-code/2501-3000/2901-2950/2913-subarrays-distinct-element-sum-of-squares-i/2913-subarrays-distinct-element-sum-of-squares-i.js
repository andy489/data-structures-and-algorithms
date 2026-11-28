// https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/

var sumCounts = function(nums) {
    const n = nums.length;
    let ans = 0;
    for (let i = 0; i < n; i++) {
        const seen = new Set();
        for (let j = i; j < n; j++) {
            seen.add(nums[j]);
            ans += seen.size * seen.size;
        }
    }
    return ans;
};
