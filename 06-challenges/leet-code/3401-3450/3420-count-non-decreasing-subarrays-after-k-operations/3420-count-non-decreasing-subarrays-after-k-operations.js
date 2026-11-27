// https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var countNonDecreasingSubarrays = function(nums, k) {
    const n = nums.length;
    let ans = 0;
    let cost = 0;
    const dq = [];
    let dqStart = 0;
    let l = 0;

    const computeCost = (l, r) => {
        let c = 0, maxVal = nums[l];
        for (let i = l + 1; i <= r; i++) {
            if (nums[i] < maxVal) c += maxVal - nums[i];
            else maxVal = nums[i];
        }
        return c;
    };

    for (let r = 0; r < n; r++) {
        while (dqStart < dq.length && nums[dq[dq.length - 1]] < nums[r]) {
            const idx = dq.pop();
            const prevIdx = dq.length > dqStart ? dq[dq.length - 1] : l - 1;
            cost += (nums[r] - nums[idx]) * (idx - prevIdx);
        }
        dq.push(r);
        while (cost > k) {
            if (dq[dqStart] === l) dqStart++;
            l++;
            while (dqStart < dq.length && dq[dqStart] < l) dqStart++;
            cost = computeCost(l, r);
        }
        ans += r - l + 1;
    }
    return ans;
};
