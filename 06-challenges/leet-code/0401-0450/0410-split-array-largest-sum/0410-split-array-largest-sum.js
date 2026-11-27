// https://leetcode.com/problems/split-array-largest-sum/

var splitArray = function(nums, k) {
    function canSplit(maxSum) {
        let subarrays = 1, current = 0;
        for (const num of nums) {
            if (current + num > maxSum) {
                subarrays++;
                current = num;
                if (subarrays > k) return false;
            } else {
                current += num;
            }
        }
        return true;
    }
    let lo = Math.max(...nums), hi = nums.reduce((a, b) => a + b, 0);
    while (lo < hi) {
        const mid = Math.floor((lo + hi) / 2);
        if (canSplit(mid)) {
            hi = mid;
        } else {
            lo = mid + 1;
        }
    }
    return lo;
};
