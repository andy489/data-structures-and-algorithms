// https://leetcode.com/problems/subarray-product-less-than-k/

var numSubarrayProductLessThanK = function(nums, k) {
    if (k <= 1) return 0;
    let count = 0, product = 1, lo = 0;
    for (let hi = 0; hi < nums.length; hi++) {
        product *= nums[hi];
        while (product >= k) {
            product /= nums[lo++];
        }
        count += hi - lo + 1;
    }
    return count;
};
