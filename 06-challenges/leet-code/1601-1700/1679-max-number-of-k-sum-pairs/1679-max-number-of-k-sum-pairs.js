// https://leetcode.com/problems/max-number-of-k-sum-pairs/

var maxOperations = function(nums, k) {
    nums.sort((a, b) => a - b);
    let l = 0, r = nums.length - 1, count = 0;
    while (l < r) {
        const sum = nums[l] + nums[r];
        if (sum === k) {
            count++;
            l++;
            r--;
        } else if (sum < k) {
            l++;
        } else {
            r--;
        }
    }
    return count;
};
