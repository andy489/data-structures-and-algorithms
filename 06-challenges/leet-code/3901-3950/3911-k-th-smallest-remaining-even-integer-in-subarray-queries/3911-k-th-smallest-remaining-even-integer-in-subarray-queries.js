// https://leetcode.com/problems/k-th-smallest-remaining-even-integer-in-subarray-queries/
/**
 * @param {number[]} nums
 * @param {number[][]} queries
 * @return {number[]}
 */
var kthSmallest = function(nums, queries) {
    const ans = [];
    for (const [l, r, k] of queries) {
        let lo = k, hi = k + (r - l + 1);
        while (lo < hi) {
            const mid = Math.floor((lo + hi) / 2);
            let removed = 0;
            for (let i = l; i <= r; i++) {
                if (nums[i] % 2 === 0 && nums[i] <= 2 * mid) {
                    removed++;
                } else if (nums[i] > 2 * mid) {
                    break;
                }
            }
            if (mid - removed >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        ans.push(2 * lo);
    }
    return ans;
};
