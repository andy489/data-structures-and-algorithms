// https://leetcode.com/problems/apply-operations-to-maximize-frequency-score/
var maxFrequencyScore = function(nums, k) {
    nums.sort((a, b) => a - b);
    const n = nums.length;
    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + nums[i];
    }

    const cost = (left, right) => {
        const mid = Math.floor((left + right) / 2);
        const leftCost = nums[mid] * (mid - left) - (prefix[mid] - prefix[left]);
        const rightCost = (prefix[right + 1] - prefix[mid + 1]) - nums[mid] * (right - mid);
        return leftCost + rightCost;
    };

    let result = 1;
    let left = 0;
    for (let right = 0; right < n; right++) {
        while (cost(left, right) > k) {
            left++;
        }
        result = Math.max(result, right - left + 1);
    }
    return result;
};
