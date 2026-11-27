// https://leetcode.com/problems/count-the-number-of-good-partitions/
var numberOfGoodPartitions = function(nums) {
    const MOD = 1_000_000_007n;
    const last = new Map();
    for (let i = 0; i < nums.length; i++) {
        last.set(nums[i], i);
    }
    let cuts = 0;
    let minEnd = 0;
    for (let i = 0; i < nums.length - 1; i++) {
        minEnd = Math.max(minEnd, last.get(nums[i]));
        if (i === minEnd) {
            cuts++;
        }
    }
    let ans = 1n;
    for (let i = 0; i < cuts; i++) {
        ans = ans * 2n % MOD;
    }
    return Number(ans);
};
