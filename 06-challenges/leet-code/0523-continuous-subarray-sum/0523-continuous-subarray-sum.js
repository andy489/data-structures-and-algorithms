// https://leetcode.com/problems/continuous-subarray-sum/

var checkSubarraySum = function(nums, k) {
    const remainderFirstSeen = new Map([[0, -1]]);
    let prefixSum = 0;
    for (let i = 0; i < nums.length; i++) {
        prefixSum = (prefixSum + nums[i]) % k;
        if (remainderFirstSeen.has(prefixSum)) {
            if (i - remainderFirstSeen.get(prefixSum) >= 2) { return true; }
        } else {
            remainderFirstSeen.set(prefixSum, i);
        }
    }
    return false;
};
