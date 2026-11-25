// https://leetcode.com/problems/subarray-sums-divisible-by-k/

var subarraysDivByK = function(nums, k) {
    const count = new Array(k).fill(0);
    count[0] = 1;
    let prefix = 0, ans = 0;
    for (const x of nums) {
        prefix = ((prefix + x) % k + k) % k;
        ans += count[prefix];
        count[prefix]++;
    }
    return ans;
};
