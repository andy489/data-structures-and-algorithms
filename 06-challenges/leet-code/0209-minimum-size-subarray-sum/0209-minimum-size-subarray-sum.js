// https://leetcode.com/problems/minimum-size-subarray-sum/

// Solution: Sliding Window — O(n) time, O(1) space
var minSubArrayLen = function(target, nums) {
    let left = 0;
    let sum = 0;
    let minLen = Infinity;

    for (let right = 0; right < nums.length; right++) {
        sum += nums[right];

        while (sum >= target) {
            minLen = Math.min(minLen, right - left + 1);
            sum -= nums[left++];
        }
    }

    return minLen === Infinity ? 0 : minLen;
};

// Solution 2: Binary Search on Prefix Sums — O(n log n) time, O(n) space
var minSubArrayLen2 = function(target, nums) {
    const n = nums.length;
    const prefix = new Array(n + 1).fill(0);

    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + nums[i];
    }

    let minLen = Infinity;

    for (let i = 0; i < n; i++) {
        const need = prefix[i] + target;
        let lo = i + 1;
        let hi = n;

        while (lo <= hi) {
            const mid = (lo + hi) >> 1;

            if (prefix[mid] >= need) {
                minLen = Math.min(minLen, mid - i);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
    }

    return minLen === Infinity ? 0 : minLen;
};
