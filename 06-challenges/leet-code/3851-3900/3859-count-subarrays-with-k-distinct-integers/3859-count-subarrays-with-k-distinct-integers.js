// https://leetcode.com/problems/count-subarrays-with-k-distinct-integers/

/**
 * @param {number[]} nums
 * @param {number} k
 * @param {number} m
 * @return {number}
 */
var countSubarrays = function(nums, k, m) {
    function atMost(K) {
        if (K < 0) return 0;
        const freq = new Map();
        let qualified = 0, count = 0, l = 0;
        for (let r = 0; r < nums.length; r++) {
            const v = nums[r];
            freq.set(v, (freq.get(v) || 0) + 1);
            if (freq.get(v) === m) qualified++;
            while (qualified > K) {
                const lv = nums[l];
                freq.set(lv, freq.get(lv) - 1);
                if (freq.get(lv) === m - 1) qualified--;
                l++;
            }
            count += r - l + 1;
        }
        return count;
    }
    return atMost(k) - atMost(k - 1);
};
