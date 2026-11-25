// https://leetcode.com/problems/subarrays-with-k-different-integers/

var subarraysWithKDistinct = function(nums, k) {
    const atMost = (k) => {
        const count = new Map();
        let res = 0, lo = 0;
        for (let hi = 0; hi < nums.length; hi++) {
            count.set(nums[hi], (count.get(nums[hi]) || 0) + 1);
            while (count.size > k) {
                count.set(nums[lo], count.get(nums[lo]) - 1);
                if (count.get(nums[lo]) === 0) count.delete(nums[lo]);
                lo++;
            }
            res += hi - lo + 1;
        }
        return res;
    };
    return atMost(k) - atMost(k - 1);
};
