// https://leetcode.com/problems/partition-equal-subset-sum/

var canPartition = function(nums) {
    const total = nums.reduce((a, b) => a + b, 0);
    if (total % 2 !== 0) { return false; }
    const target = total / 2;
    const reachable = new Array(target + 1).fill(false);
    reachable[0] = true;
    for (const num of nums) {
        for (let j = target; j >= num; j--) {
            reachable[j] = reachable[j] || reachable[j - num];
        }
    }
    return reachable[target];
};
