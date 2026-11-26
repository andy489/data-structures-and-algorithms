// https://leetcode.com/problems/find-k-th-smallest-pair-distance/

var smallestDistancePair = function(nums, k) {
    nums.sort((a, b) => a - b);
    const n = nums.length;

    function countPairs(dist) {
        let count = 0, left = 0;
        for (let right = 1; right < n; right++) {
            while (nums[right] - nums[left] > dist) left++;
            count += right - left;
        }
        return count;
    }

    let lo = 0, hi = nums[n-1] - nums[0];
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (countPairs(mid) >= k) {
            hi = mid;
        } else {
            lo = mid + 1;
        }
    }
    return lo;
};
